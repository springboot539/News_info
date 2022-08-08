package com.example.news_info;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.news_info.adapter.AddItemAdapter;
import com.example.news_info.bean.TypeBean;
import com.example.news_info.db.DBManager;

import java.util.ArrayList;
import java.util.List;

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBackIv;
    private ListView mAddLv;
    List<TypeBean> mDatas;
    private AddItemAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        mBackIv = findViewById(R.id.add_iv_back);
        mAddLv = findViewById(R.id.add_lv);
        mBackIv.setOnClickListener(this);
        mDatas = DBManager.getAllTypeList();
//        创建适配器对象
        mAdapter = new AddItemAdapter(this, mDatas);
        mAddLv.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_iv_back:
//                销毁当前页面返回上一个Activity
                finish();
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        DBManager.updateTypeList(mDatas);
    }
}
