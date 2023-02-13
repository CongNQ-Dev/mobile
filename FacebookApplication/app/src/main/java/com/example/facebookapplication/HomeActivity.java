package com.example.facebookapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<featureModel> featureModels = new ArrayList<>();
    int[] featureImages = {R.drawable.ic_pharmacy, R.drawable.ic_baby, R.drawable.ic_cart, R.drawable.ic_home,
            R.drawable.ic_pharmacy, R.drawable.ic_baby, R.drawable.ic_cart, R.drawable.ic_home};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = findViewById(R.id.mRecycleView);

        setUpFeatureModels();

        featureAdapter adapter = new featureAdapter(this, featureModels, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void setUpFeatureModels(){
        String[] featureName = getResources().getStringArray(R.array.feature_full_txt);

        for (int i = 0; i < featureName.length; i++) {
            featureModels.add(new featureModel(featureName[i], featureImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(HomeActivity.this, DetailActivity.class);

        intent.putExtra("NAME",featureModels.get(position).getName());

        startActivity(intent);
    }
}