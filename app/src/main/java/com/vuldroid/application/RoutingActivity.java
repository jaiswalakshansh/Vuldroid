package com.vuldroid.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class RoutingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arbifile);
    }

    @Override
    protected void onResume() {
        super.onResume();

        handleIntentExtras(getIntent()); // anything can be passed to getIntent() here
    }

    private void handleIntentExtras(Intent intent) {

        Intent routerintent = intent.getParcelableExtra("router_component");
        startActivity(routerintent);
    }
}