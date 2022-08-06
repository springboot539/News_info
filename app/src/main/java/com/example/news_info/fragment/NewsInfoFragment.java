package com.example.news_info.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.news_info.R;
import com.example.news_info.adapter.InfoItemAdapter;
import com.example.news_info.bean.InfoBean;
import com.example.news_info.bean.TypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsInfoFragment extends Fragment {

    ListView mListView;
    private String url;
//ListView的数据源
    List<InfoBean.ResultBean.DataBean> mDatas;
    private InfoItemAdapter mAdapter;


    public NewsInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView = view.findViewById(R.id.newsfrag_lv);
//        获取activity传递的数据
        Bundle bundle = getArguments();
        TypeBean typeBean = (TypeBean) bundle.getSerializable("type");
        url = typeBean.getUrl();
        mDatas = new ArrayList<>();
//        创建ListView的适配器对象
        mAdapter = new InfoItemAdapter(getActivity(), mDatas);
        mListView.setAdapter(mAdapter);

    }
}
