package com.vuldroid.application;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        Dashboard.super.onBackPressed();
                        System.exit(0);
                    }
                }).create().show();
    }

    public void youtubeview(View view){
        Intent intent =new Intent(getApplicationContext(), YoutubeViewer.class);
        startActivity(intent);
    }

    public void blogsview(View view){
        Intent intent =new Intent(getApplicationContext(), BlogsViewer.class);
        startActivity(intent);
    }

    public void notesview(View view){
        Intent intent =new Intent(getApplicationContext(), NotesViewer.class);
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

    public  void rootview(View v){
        Intent intent =new Intent(getApplicationContext(), RootDetection.class);
        startActivity(intent);
    }

public void logout(View view){
    FirebaseAuth.getInstance().signOut();
    finish();
    startActivity(new Intent(getApplicationContext(), UserLogin.class));
}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

}