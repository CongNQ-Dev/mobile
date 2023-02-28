package com.example.facebookapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailCategoriesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_detail);
        CategoriesModel category = (CategoriesModel) getIntent().getSerializableExtra("category");

        TextView title = findViewById(R.id.storeText);
        ImageView thumbnail = findViewById(R.id.storeImage);
        TextView content = findViewById(R.id.storePhoneNumber);
        ImageView button = findViewById(R.id.storeCallButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+category.getPhoneNumber()));
                startActivity(intent);
            }
        });
//
        title.setText("You are on page " + category.getName() + " detail.");
        thumbnail.setImageResource(category.getImage());
        content.setText(category.getPhoneNumber());

//        content.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                clickRequestPermission();
//            }
//        });
    }
}
