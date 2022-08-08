package com.example.news_info.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.news_info.bean.NewsURL;

public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(@Nullable Context context) {
        super(context, "info.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table itype(id integer primary key,title varchar(10) unique not null,url text not null,isshow varchar(10) not null)";
        db.execSQL(sql);
        String insertSql = "insert into itype values(?,?,?,?)";
        db.execSQL(insertSql,new Object[]{1," 头条", NewsURL.HEADLINE_URL,"true"});
        db.execSQL(insertSql,new Object[]{2," 社会", NewsURL.SOCIETY_URL,"true"});
        db.execSQL(insertSql,new Object[]{3," 国内", NewsURL.HOME_URL,"true"});
        db.execSQL(insertSql,new Object[]{4," 国际", NewsURL.INTERNATION_URL,"true"});
        db.execSQL(insertSql,new Object[]{5," 娱乐", NewsURL.ENTERTRAINMENT_URL,"true"});
        db.execSQL(insertSql,new Object[]{6," 体育", NewsURL.SPORT_URL,"false"});
        db.execSQL(insertSql,new Object[]{7," 军事", NewsURL.MILITARY_URL,"false"});
        db.execSQL(insertSql,new Object[]{8," 科技", NewsURL.SCIENCE_URL,"false"});
        db.execSQL(insertSql,new Object[]{9," 财经", NewsURL.FINANCE_URL,"false"});
        db.execSQL(insertSql,new Object[]{10,"时尚", NewsURL.FASHION_URL,"false"});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
