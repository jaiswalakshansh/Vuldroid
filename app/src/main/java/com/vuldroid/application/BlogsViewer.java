package com.vuldroid.application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BlogsViewer extends AppCompatActivity {
    String gettoken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogsviewer);
        Bundle extras = getIntent().getExtras();
        if(extras == null){
             WebView vulnerable =(WebView) findViewById(R.id.loads);
            WebSettings webSettings = vulnerable.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setAllowFileAccessFromFileURLs(true);
            vulnerable.setWebChromeClient(new WebChromeClient());
            WebViewClientImpl webViewClient = new WebViewClientImpl(this);
            vulnerable.setWebViewClient(webViewClient);
            vulnerable.loadUrl("https://medium.com"); }

            else{gettoken=getIntent().getData().getQueryParameter("url");
            WebView vulnerable =(WebView) findViewById(R.id.loads);
            WebSettings webSettings = vulnerable.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setAllowFileAccess(true);
            webSettings.setAllowFileAccessFromFileURLs(true);
            webSettings.setAllowUniversalAccessFromFileURLs(true);
            vulnerable.setWebChromeClient(new WebChromeClient());
            WebViewClientImpl webViewClient = new WebViewClientImpl(this);
            vulnerable.setWebViewClient(webViewClient);
            vulnerable.loadUrl(gettoken);}

    }}
    class WebViewClientImpl extends WebViewClient {

        private Activity activity = null;

        public WebViewClientImpl(Activity activity) {
            this.activity = activity;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            return false;

        }

    }

