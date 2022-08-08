package com.example.news_info.fragment;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.news_info.Utils.UniteApp;

public class BaseFragment extends Fragment implements Response.Listener<String>, Response.ErrorListener {


    private static final String TAG = "BaseFragment";

    /**
     * 创建网络请求对象 StringRequest, JsonRequest
     *
     * @param url
     */
    public void loadData(String url) {
        StringRequest stringRequest = new StringRequest(url, this, this);
//        将请求添加到请求队列中
        UniteApp.getHttpQueue().add(stringRequest);
    }


    /**
     * 获取网络请求成功时回调的方法
     *
     * @param response
     */
    @Override
    public void onResponse(String response) {
        Log.d(TAG, "这个是在BaseFragment中调用onResponse......");
    }

    /**
     * 获取网络请求失败的时候回调的方法
     * @param error
     */
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d(TAG, "onErrorResponse: ");
        Log.d(TAG, "这个是在BaseFragment中调用onErrorResponse......");
    }
}
