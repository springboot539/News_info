package com.example.news_info.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.news_info.bean.TypeBean;

import java.util.List;

public class NewsInfoAdpter extends FragmentStatePagerAdapter {

    Context mContext;
    List<Fragment> mFragmentList; // viewPager每个页面展示的fragment的集合
    List<TypeBean> mTypeBeanList;


    public NewsInfoAdpter(@NonNull FragmentManager fm, Context context, List<Fragment> fragmentList, List<TypeBean> typeBeanList) {
        super(fm);
        mContext = context;
        mFragmentList = fragmentList;
        mTypeBeanList = typeBeanList;
    }

    public NewsInfoAdpter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    /**
     * 标题和内容之间的关系需要重写
     * @param position
     * @return
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        TypeBean typeBean = mTypeBeanList.get(position);
        String title = typeBean.getTitle();
        return title;
    }
}
