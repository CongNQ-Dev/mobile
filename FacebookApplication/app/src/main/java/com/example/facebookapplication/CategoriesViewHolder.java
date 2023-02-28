package com.example.facebookapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {
    public ImageView categoryIcon;
    public TextView categoryName;

    public CategoriesViewHolder(@NonNull View itemView) {
        super(itemView);

        categoryIcon = itemView.findViewById(R.id.imageView);
        categoryName = itemView.findViewById(R.id.textView);
    }

    public void bind(CategoriesModel category) {
        categoryIcon.setImageResource(category.getImage());
        categoryName.setText(category.getName());
    }
}
