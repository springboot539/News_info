package com.example.news_info;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.news_info.adapter.NewsInfoAdpter;
import com.example.news_info.bean.TypeBean;
import com.example.news_info.db.DBManager;
import com.example.news_info.fragment.NewsInfoFragment;
import com.example.news_info.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager mViewPager;
    PagerSlidingTabStrip mTabStrip;
    ImageView addIv;
    List<Fragment> mFragmentList; //ViewPager显示的内容
    List<TypeBean> mTypeBeanList; //选中类型的集合
    private NewsInfoAdpter mAdpter;

    private final int REQUEST_CODE_ADDRESS = 100;

    private void checkPermissioin() {
        int checkInternet = checkSelfPermission(Manifest.permission.INTERNET);
        int checkInternetState = checkSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE);
        if (checkInternet == PackageManager.PERMISSION_GRANTED && checkInternetState == PackageManager.PERMISSION_GRANTED) {
            //已经授权
            Toast.makeText(this, "不用请求已经有了权限", Toast.LENGTH_SHORT).show();
        } else {//没有权限
            requestPermissions(new String[]{Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE}, REQUEST_CODE_ADDRESS);//申请授权

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case REQUEST_CODE_ADDRESS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted 授予权限
                    //处理授权之后逻辑
                    Toast.makeText(this, "已经获取权限", Toast.LENGTH_SHORT).show();
                } else {
                    // Permission Denied 权限被拒绝
                    Toast.makeText(this, "拒绝权限，无法使用！请手动代开权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermissioin();
        mViewPager = findViewById(R.id.main_vp);
        mTabStrip = findViewById(R.id.main_tabstrip);
        addIv = findViewById(R.id.main_iv_add);
        addIv.setOnClickListener(this);
        mFragmentList = new ArrayList<>();
        mTypeBeanList = new ArrayList<>();
        initPager();
//      创建适配器对象
        mAdpter = new NewsInfoAdpter(getSupportFragmentManager(), this, mFragmentList, mTypeBeanList);
        mViewPager.setAdapter(mAdpter);
//      需要设置ViewPager和TabStrip关联
        mTabStrip.setViewPager(mViewPager);
    }

    private void initPager() {
//        List<TypeBean> typeList = TypeBean.getTypeList();
        List<TypeBean> typeList = DBManager.getSelectedTypeList();
        mTypeBeanList.addAll(typeList);
        for (int i = 0; i < mTypeBeanList.size(); i++) {
            TypeBean typeBean = mTypeBeanList.get(i);
            NewsInfoFragment newsInfoFragment = new NewsInfoFragment();
//            向Fragmemt中传递数据
            Bundle bundle = new Bundle();
            bundle.putSerializable("type", typeBean);
            newsInfoFragment.setArguments(bundle);
            mFragmentList.add(newsInfoFragment);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_iv_add:
                startActivity(new Intent(MainActivity.this, AddItemActivity.class));
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mFragmentList.clear();
        mTypeBeanList.clear();

        initPager();
        mAdpter.notifyDataSetChanged();
        mTabStrip.notifyDataSetChanged();
    }
}
