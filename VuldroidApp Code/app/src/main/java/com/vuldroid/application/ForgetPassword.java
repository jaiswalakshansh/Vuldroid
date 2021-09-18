package com.vuldroid.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        Intent intent = getIntent();
        Uri data= intent.getData();
        WebView fireb =(WebView) findViewById(R.id.webv);
        WebSettings firebs =fireb.getSettings();
        firebs.setJavaScriptEnabled(true);
        fireb.setWebChromeClient(new WebChromeClient());
        fireb.loadUrl(data.toString());
    }

    public void dashboard(View view){
        Intent into =new Intent(ForgetPassword.this, UserLogin.class);
        startActivity(into);
    }

}