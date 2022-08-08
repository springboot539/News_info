package com.example.news_info.fragment;


import android.content.Intent;
import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.example.news_info.DescActivity;
import com.example.news_info.R;
import com.example.news_info.adapter.InfoItemAdapter;
import com.example.news_info.bean.InfoBean;
import com.example.news_info.bean.TypeBean;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsInfoFragment extends BaseFragment {


    private static final String TAG = "NewsInfoFragment";
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
        View view = inflater.inflate(R.layout.fragment_news_info, container, false);
        mListView = view.findViewById(R.id.newsfrag_lv);
//        获取activity传递的数据
        Bundle bundle = getArguments();
        TypeBean typeBean = (TypeBean) bundle.getSerializable("type");
        url = typeBean.getUrl();


        mDatas = new ArrayList<>();
//        创建ListView的适配器对象
        mAdapter = new InfoItemAdapter(getActivity(), mDatas);
        mListView.setAdapter(mAdapter);
        loadData(url);
        setListener();
        return view;
    }

    /**
     * 设置点一个新闻点击后的跳转事件
     */
    private void setListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                InfoBean.ResultBean.DataBean dataBean = mDatas.get(position);
                String url = dataBean.getUrl();
                Intent intent = new Intent(getActivity(), DescActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

    }

    /**
     * 报错，没有进入该方法
     *
     * @param response
     */
    @Override
    public void onResponse(String response) {
        Log.d(TAG, "这个是在NewsInfoFragment中调用onResponse......");
        InfoBean infoBean = new Gson().fromJson(response, InfoBean.class);
        if (!(infoBean.getError_code() == 10012)) {
            List<InfoBean.ResultBean.DataBean> list = infoBean.getResult().getData();
        }
        List list = new ArrayList();
//        添加到数据源中
        mDatas.addAll(list);
//        提醒adapter数据源发生变化
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 这里有问题，对于JSON数据的处理没做完
     *
     * @param error
     */
//    TODO 处理返回数据
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d(TAG, "这个是在NewsInfoFragment中调用onErrorResponse......" + error);
//        Log.d(TAG, "这个是在NewsInfoFragment中调用onErrorResponse......" + String.valueOf(url));
    }
}
