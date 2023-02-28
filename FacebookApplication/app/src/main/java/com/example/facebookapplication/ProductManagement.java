package com.example.facebookapplication;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookapplication.adapter.ProductAdapter;
import com.example.facebookapplication.db.ProductDatabase;
import com.example.facebookapplication.entity.Product;

import java.util.List;

public class ProductManagement extends AppCompatActivity {
    private RecyclerView mRecyclerProduct;
    private ProductAdapter mProductAdapter ;
    private List<Product> products;
    private ProductDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_manager);


        mDb = ProductDatabase.getInMemoryDatabase(getApplicationContext());
        products = mDb.getProductsDAO().getAllProducts();
        mProductAdapter = new ProductAdapter(this, products,mDb);

        mRecyclerProduct = findViewById(R.id.recyclerView_product);

//
        Button createBtn = findViewById(R.id.create_btn);
//
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertProduct();
                products.clear();
                products.addAll(mDb.getProductsDAO().getAllProducts());
                mProductAdapter.notifyDataSetChanged();
            }
        });

        mRecyclerProduct.setAdapter(mProductAdapter);
        mRecyclerProduct.setLayoutManager(new LinearLayoutManager(this));
    }
    private void insertProduct() {
        EditText productNameEditText = findViewById(R.id.product_name_create);
        EditText productDescriptionEditText = findViewById(R.id.product_description_create);
        EditText productPriceEditText = findViewById(R.id.product_price_create);
        String name = productNameEditText.getText().toString();
        String description = productDescriptionEditText.getText().toString();
        int price = Integer.parseInt(productPriceEditText.getText().toString());

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        mDb.getProductsDAO().insert(product);


        mProductAdapter.notifyItemInserted(mProductAdapter.getItemCount() - 1);

    }
}