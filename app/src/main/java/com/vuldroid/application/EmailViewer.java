package com.vuldroid.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class EmailViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_viewer);
        MyReceiver myReceiver =new MyReceiver();
        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction("com.example.Broadcast");
        registerReceiver(myReceiver,intentFilter);
        Intent i =new Intent();
        i.setAction("com.example.Broadcast");
        sendBroadcast(i);
    }
}