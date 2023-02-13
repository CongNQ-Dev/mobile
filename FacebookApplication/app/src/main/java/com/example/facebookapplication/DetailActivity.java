package com.example.facebookapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String name = getIntent().getStringExtra("NAME");

        TextView nameTextView = findViewById(R.id.resultTv);

        nameTextView.setText("You are on page " + name + " detail.");
    }
}
