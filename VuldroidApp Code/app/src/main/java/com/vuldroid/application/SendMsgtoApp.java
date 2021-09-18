package com.vuldroid.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SendMsgtoApp extends AppCompatActivity {
    EditText ext;
    public  void sendmesage(View v){
        Intent intent =new Intent();
        ext=findViewById(R.id.ed1);
        String valu =ext.getText().toString();
        intent.putExtra("secret",valu);
        intent.setAction("com.app.innocent.recievemsg");
        intent.addCategory("android.intent.category.DEFAULT");
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msgto_app);
    }
}