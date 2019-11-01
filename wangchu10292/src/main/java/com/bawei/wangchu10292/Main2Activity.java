package com.bawei.wangchu10292;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //接收数据
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        WebView webView = new WebView(Main2Activity.this);
        webView.loadUrl(url);
        setContentView(webView);
    }
}
