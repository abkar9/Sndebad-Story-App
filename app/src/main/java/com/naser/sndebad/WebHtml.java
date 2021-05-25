package com.naser.sndebad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class WebHtml extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_html);
        webView=findViewById(R.id.webView);
        Intent data =getIntent();
        int page =data.getExtras().getInt("page");
        page++;
        webView.loadUrl("file:///android_asset/html/"+page+".html");
    }
}