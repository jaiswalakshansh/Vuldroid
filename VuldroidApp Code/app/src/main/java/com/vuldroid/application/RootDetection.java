package com.vuldroid.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RootDetection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_root_detection);
        if (getIntent().hasExtra("command")) {
            try {
                Process process=Runtime.getRuntime().exec(getIntent().getStringExtra("command"));
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder log=new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    log.append(line+"\n");
                }
                TextView t1=findViewById(R.id.roottext);
                t1.setText(log.toString());
            }

            catch (Exception e) {
                TextView t1=findViewById(R.id.roottext);
                t1.setText("Device is ok rooted");
            }
        }
        else{
        try {
            Process process=Runtime.getRuntime().exec("su");
            TextView t1=findViewById(R.id.roottext);
            t1.setText("Device is rooted");
        }

        catch (Exception e) {
            TextView t1=findViewById(R.id.roottext);
            t1.setText("Device is not rooted");
        }}
    }
}