package com.example.facebookapplication;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String name = getIntent().getStringExtra("NAME");
        int image = getIntent().getIntExtra("IMAGE",0);
        String phone = getIntent().getStringExtra("PHONE");

        TextView nameTextView = findViewById(R.id.storeText);
        ImageView imageTextView = findViewById(R.id.storeImage);
        TextView phoneNumber = findViewById(R.id.storePhoneNumber);
        ImageView button = findViewById(R.id.storeCallButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });

        imageTextView.setImageResource(image);
        nameTextView.setText("You are on page " + name + " detail.");
        phoneNumber.setText(phone);
    }
}
