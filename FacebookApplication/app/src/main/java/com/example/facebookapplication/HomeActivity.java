package com.example.facebookapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //intent to get data
        Intent intent = getIntent();
        String email = intent.getStringExtra("EMAIL");
        String password = intent.getStringExtra("PASSWORD");

        //TextView
        TextView mResultTv = findViewById(R.id.resultTv);

        //setText
        mResultTv.setText("User Login with email: " + email + " and password: " + password);

        Button mBackbtn = findViewById(R.id.btnBack);

        mBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                Toast.makeText(HomeActivity.this,"Redirecting...",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}