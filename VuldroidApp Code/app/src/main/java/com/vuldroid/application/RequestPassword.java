package com.vuldroid.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class RequestPassword extends AppCompatActivity {
FirebaseAuth firebaseAuth;
    EditText useremail;
    Button passreset;
    public void forgets(View view){
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.sendPasswordResetEmail(useremail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RequestPassword.this,"Email sent, Open email app",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(RequestPassword.this, UserLogin.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void loginmenu(View view){
        Intent into =new Intent(RequestPassword.this, UserLogin.class);
        startActivity(into);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestpassword);
        useremail = findViewById(R.id.forgotemail_editText);
        passreset =findViewById(R.id.forgotfirebase);
    }
}