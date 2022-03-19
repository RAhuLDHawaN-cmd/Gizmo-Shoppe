package com.example.individualandroidporject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.individualandroidporject.ProductsSchema.ProductsSchema;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class Products extends AppCompatActivity{
    ProductsSchema[] products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        initilizeData();

        RecyclerView productsList = findViewById(R.id.productsList);
        productsList.setLayoutManager(new LinearLayoutManager(this));
        productsList.setAdapter(new ProductsListAdapter(products));


    }

    public void initilizeData(){
        Bundle extras = getIntent().getExtras();
        String p1 = null;
        if (extras != null) {
            String value = extras.getString("data");
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            products = gson.fromJson(value, ProductsSchema[].class);
            p1 = products[0].getTitle();
        }
    }


}