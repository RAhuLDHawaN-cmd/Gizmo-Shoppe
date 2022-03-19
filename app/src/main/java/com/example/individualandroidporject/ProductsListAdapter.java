package com.example.individualandroidporject;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.individualandroidporject.ProductsSchema.ProductsSchema;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ProductsViewHolder> {

    ProductsSchema[] data;

    public ProductsListAdapter(ProductsSchema[] data){
        this.data=data;

    }


    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.productslist,parent,false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
            String productTitle = data[position].getTitle();
            holder.productTitle.setText(productTitle);
            Glide.with(holder.productImg.getContext()).load(data[position].getImage()).into(holder.productImg);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {
        ImageView productImg;
        TextView productTitle;
        TextView price;
        CardView cardView;


        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            productImg = itemView.findViewById(R.id.productImg);

            productTitle = itemView.findViewById(R.id.productTitle);

            cardView = itemView.findViewById(R.id.productCardId);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ProductsSchema productsSchema = data[getAdapterPosition()];

                    Intent i = new Intent(itemView.getContext(), SingleProduct.class);
                    i.putExtra("title",productsSchema.getTitle());
                    i.putExtra("description",productsSchema.getDescription());
                    i.putExtra("price",productsSchema.getPrice());
                    i.putExtra("image",productsSchema.getImage());

                    itemView.getContext().startActivity(i);
                }
            });
        }
    }


}
