package com.example.facebookapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText
        final EditText mEmailEt = findViewById(R.id.edEmail);
        final EditText mPasswordEt = findViewById(R.id.edPassword);
        //Button
        Button mLoginBtn = findViewById(R.id.btnLogin);

        //button click listener
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data from edit text
                String email = mEmailEt.getText().toString();
                String password = mPasswordEt.getText().toString();

                //activity intent
                if(email.equals("admin@gmail.com")&&password.equals("123456")){
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    intent.putExtra("EMAIL",email);
                    intent.putExtra("PASSWORD", password);
                    Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Wrong credential",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}