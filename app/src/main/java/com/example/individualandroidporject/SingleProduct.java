package com.example.individualandroidporject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SingleProduct extends AppCompatActivity {
    TextView pTitle;
    TextView pDesc;
    ImageView pImage;
    Button pPrice;
    TextView Tprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product);

        String price = String.valueOf(getIntent().getDoubleExtra("price",1.0));


        pTitle = findViewById(R.id.pTitle);
        pDesc = findViewById(R.id.pDesc);
        pImage = findViewById(R.id.pImage);
        pPrice = findViewById(R.id.pPrice);
        Tprice= findViewById(R.id.SpecialPrice);



        pTitle.setText(getIntent().getStringExtra("title"));
        pDesc.setText(getIntent().getStringExtra("description"));

        pPrice.setText("add to cart");
        Tprice.setText("$ "+price);

        

        Glide.with(this).load(getIntent().getStringExtra("image")).into(pImage);


        pPrice.setOnClickListener(view -> {

            Intent test=new Intent(this, checkout_f.class);
            Log.i("info", "Start form");
            startActivity(test);
        });

    }
}