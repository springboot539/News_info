package com.example.news_info;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DescActivity extends AppCompatActivity {

    private WebView mDescWeb;
    private String mUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        mDescWeb = findViewById(R.id.desc_webview);
        mUrl = getIntent().getStringExtra("url");
//        设置WebView的设置类，对于属性进行设置
        WebSettings settings = mDescWeb.getSettings();
//        设置页面支持js交互
        settings.setJavaScriptEnabled(true);
//        将图片调整到适合WebView的大小
        settings.setUseWideViewPort(true);
//        缩放直屏幕的大小
        settings.setLoadWithOverviewMode(true);
//        设置webView的缩放方式
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        设置可以访问文件
        settings.setAllowFileAccess(true);
//        支持js打开新窗口
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
//        设置自动加载图片
        settings.setLoadsImagesAutomatically(true);
//        设置编码格式
        settings.setDefaultTextEncodingName("utf-8");
        mDescWeb.loadUrl(mUrl);

//        默认通过手机浏览器打开网址，如果想要使用WebView直接打开网址，需要设置
        mDescWeb.setWebViewClient(new WebViewClient() {
            //        重写方法，需要返回true
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                使用WebView加载Url
                view.loadUrl(mUrl);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mDescWeb.canGoBack()) {
            mDescWeb.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
