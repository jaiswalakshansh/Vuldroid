package com.vuldroid.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    public void youtubeview(View view){
        Intent intent =new Intent(getApplicationContext(),youtubeviewer.class);
        startActivity(intent);
    }

    public void blogsview(View view){
        Intent intent =new Intent(getApplicationContext(),blogsviewer.class);
        startActivity(intent);
    }

    public void notesview(View view){
        Intent intent =new Intent(getApplicationContext(),notesviewer.class);
        startActivity(intent);
    }
    public void sendmsgtoapp(View view){
        Intent intent =new Intent(getApplicationContext(),SendMsgtoApp.class);
        startActivity(intent);
    }

    public  void emailview(View v){
        Intent intent =new Intent(getApplicationContext(), EmailViewer.class);
        startActivity(intent);
    }

public void logout(View view){
    FirebaseAuth.getInstance().signOut();
    finish();
    startActivity(new Intent(getApplicationContext(), userlogin.class));
}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

}