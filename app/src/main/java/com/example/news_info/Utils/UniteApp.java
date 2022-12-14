package com.example.news_info.Utils;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.news_info.db.DBManager;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class UniteApp extends Application {

    /**
     * 创建Volle有需要的请求队列
     */
    private static RequestQueue httpQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        //声明全局的数据库对象
        DBManager.initDB(this);

        httpQueue = Volley.newRequestQueue(this);
        initImageLoader(getApplicationContext());
    }


    public static RequestQueue getHttpQueue() {
        return httpQueue;
    }

    /**
     * 初始化ImageLoader
     *
     * @param context
     */
    private void initImageLoader(Context context) {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.MAX_PRIORITY)//线程优先级
                .denyCacheImageMultipleSizesInMemory()//是否使用缓存
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//MD5在磁盘中的命名方式
                .tasksProcessingOrder(QueueProcessingType.LIFO)//最近最少使用
                .writeDebugLogs()//打印日志
                .build();

        ImageLoader.getInstance().init(configuration);
    }
}
