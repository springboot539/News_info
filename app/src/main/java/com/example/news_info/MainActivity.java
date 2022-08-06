package com.example.news_info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.news_info.adapter.NewsInfoAdpter;
import com.example.news_info.bean.TypeBean;
import com.example.news_info.fragment.NewsInfoFragment;
import com.example.news_info.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager mViewPager;
    PagerSlidingTabStrip mTabStrip;
    ImageView addIv;
    List<Fragment> mFragmentList; //ViewPager显示的内容
    List<TypeBean> mTypeBeanList; //选中类型的集合
    private NewsInfoAdpter mAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        List<TypeBean> typeList = TypeBean.getTypeList();
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

    }
}
