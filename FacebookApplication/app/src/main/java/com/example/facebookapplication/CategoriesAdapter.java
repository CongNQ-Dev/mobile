package com.example.facebookapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {

    Context context;
    List<CategoriesModel> categoriesModels;

    public CategoriesAdapter(Context context, ArrayList<CategoriesModel> categoriesModel){
        this.context = context;
        this.categoriesModels = categoriesModel;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.categories_row, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        final CategoriesModel category = categoriesModels.get(position);

        holder.categoryName.setText(categoriesModels.get(position).getName());
        holder.categoryIcon.setImageResource(categoriesModels.get(position).getImage());

        holder.categoryIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailCategoriesActivity.class);
                intent.putExtra("category", category);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return categoriesModels.size();
    }
}