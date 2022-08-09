package com.example.news_info.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.news_info.bean.TypeBean;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    public static SQLiteDatabase database;

    public static void initDB(Context context) {
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        database = dbOpenHelper.getWritableDatabase();
    }


    /**
     * 获取数据库中全部行的内容，存储到集合中
     */
    public static List<TypeBean> getAllTypeList() {
        List<TypeBean> list = new ArrayList<>();
        Cursor cursor = database.query("itype", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String url = cursor.getString(cursor.getColumnIndex("url"));
            String showStr = cursor.getString(cursor.getColumnIndex("isshow"));
            Boolean isshow = Boolean.valueOf(showStr);
            TypeBean typeBean = new TypeBean(id, title, url, isshow);
            list.add(typeBean);
        }
        return list;
    }


    /**
     * 修改数据库当中行信息当中的选中记录
     */
    public static void updateTypeList(List<TypeBean> typeBeanList) {
        for (int i = 0; i < typeBeanList.size(); i++) {
            TypeBean typeBean = typeBeanList.get(i);
            String title = typeBean.getTitle();
            ContentValues contentValues = new ContentValues();
            contentValues.put("isshow", String.valueOf(typeBean.isShow()));
            database.update("itype", contentValues, "title=?", new String[]{title});
        }
    }

    /**
     * 获取所有要求显示的内容集合
     */
    public static List<TypeBean> getSelectedTypeList() {
        List<TypeBean> list = new ArrayList<>();
        Cursor itype = database.query("itype", null, "isshow=true", null, null, null, null);
        while (itype.moveToNext()) {
            int id = itype.getInt(itype.getColumnIndex("id"));
            String title = itype.getString(itype.getColumnIndex("title"));
            String url = itype.getString(itype.getColumnIndex("url"));
            TypeBean typeBean = new TypeBean(id, title, url, true);
            list.add(typeBean);
        }
        return list;
    }


}
