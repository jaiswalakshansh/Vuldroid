package com.vuldroid.application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class YoutubeViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_youtubeviewer);
        String lods = "https://youtube.com";
        WebView vulnerable =(WebView) findViewById(R.id.vulweb);
        WebSettings webSettings = vulnerable.getSettings();
        webSettings.setAllowFileAccess(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        vulnerable.setWebChromeClient(new WebChromeClient());
        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        vulnerable.setWebViewClient(webViewClient);
        if ((getIntent() != null) || getIntent().hasExtra("intent_url")) {
            vulnerable.loadUrl(getIntent().getStringExtra("intent_url"));
        }
        else{vulnerable.loadUrl(lods);}
    }
    public class WebViewClientImpl extends WebViewClient {

        private Activity activity = null;

        public WebViewClientImpl(Activity activity) {
            this.activity = activity;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            return false;

        }

    }
    }
