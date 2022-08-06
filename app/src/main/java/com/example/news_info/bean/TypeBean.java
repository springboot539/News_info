package com.example.news_info.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 绑定接口名称和类型的类
 */
public class TypeBean implements Serializable {

    private int id;
    private String title;
    private String url;
    private boolean isShow;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public TypeBean() {
    }

    public TypeBean(int id, String title, String url, boolean isShow) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.isShow = isShow;
    }

    public static List<TypeBean> getTypeList() {
        List<TypeBean> mDatas = new ArrayList<>();
        TypeBean tb1 = new TypeBean(1, "头条", NewsURL.HEADLINE_URL, true);
        TypeBean tb2 = new TypeBean(2, "社会", NewsURL.SOCIETY_URL, true);
        TypeBean tb3 = new TypeBean(3, "国内", NewsURL.HOME_URL, true);
        TypeBean tb4 = new TypeBean(4, "国际", NewsURL.INTERNATION_URL, true);
        TypeBean tb5 = new TypeBean(5, "娱乐", NewsURL.ENTERTRAINMENT_URL, true);
        TypeBean tb6 = new TypeBean(6, "体育", NewsURL.SPORT_URL, true);
        TypeBean tb7 = new TypeBean(7, "军事", NewsURL.MILITARY_URL, true);
        TypeBean tb8 = new TypeBean(8, "科技", NewsURL.SCIENCE_URL, true);
        TypeBean tb9 = new TypeBean(9, "财经", NewsURL.FINANCE_URL, true);
        TypeBean tb10 = new TypeBean(10, "时尚", NewsURL.FASHION_URL, true);
        mDatas.add(tb1);
        mDatas.add(tb2);
        mDatas.add(tb3);
        mDatas.add(tb4);
        mDatas.add(tb5);
        mDatas.add(tb6);
        mDatas.add(tb7);
        mDatas.add(tb8);
        mDatas.add(tb9);
        mDatas.add(tb10);
        return mDatas;
    }
}
