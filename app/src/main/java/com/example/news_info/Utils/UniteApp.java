package com.example.news_info.Utils;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class UniteApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initImageLoader(getApplicationContext());
    }

    /**
     * 初始化ImageLoader
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
