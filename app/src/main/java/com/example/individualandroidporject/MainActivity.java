package com.example.individualandroidporject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {
    Button btnProducts;

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;

private String url = "https://fakestoreapi.com/products/category/electronics";
    String products;

    ViewPager mViewPager;

    // images array
    int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a5};

    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getProducts();

        btnProducts = findViewById(R.id.getProducts);
        btnProducts.setOnClickListener(view -> {
            Intent i = new Intent(this, Products.class);
             Log.i("info",products);

             i.putExtra("data",products);

             startActivity(i);


        });
    }


    public void getProducts(){
        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    products=response;
            }

        }, new Response.ErrorListener() {
            private static final String TAG = "TAG";

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,"Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    };
}