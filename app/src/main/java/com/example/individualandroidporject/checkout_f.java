package com.example.individualandroidporject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class checkout_f extends AppCompatActivity {

    Button checkbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);

        checkbtn= findViewById(R.id.btnCheckout);

        checkbtn.setOnClickListener(view -> {
            Toast.makeText(this,"Items added to cart",Toast.LENGTH_SHORT).show();
            Intent test=new Intent(this, Products.class);

            startActivity(test);
        });




    }

}
