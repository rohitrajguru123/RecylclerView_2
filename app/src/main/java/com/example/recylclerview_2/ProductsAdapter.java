package com.example.recylclerview_2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    ArrayList<Product> productsArrayList;
    TextView txtViewHol1,txtViewHol2;
    ImageView imgViewHolder;
    ImageView imgView;

    public ProductsAdapter(ArrayList<Product> products) {
        this.productsArrayList = products;
    }
    class ProductViewHolder extends RecyclerView.ViewHolder{
        Product product;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imgViewHolder);

            imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    product = productsArrayList.get(getAdapterPosition());

                    Intent intent = new Intent(view.getContext(), ProductDetailsActivity.class);
                    //way 2
                    intent.putExtra("product",product);
                    //way 1
//                    intent.putExtra("productId",product.productId);
//                    intent.putExtra("productTitle",product.productTitle);
//                    intent.putExtra("productImage",product.productImage);
//                    intent.putExtra("productPrice",product.productPrice);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View productView = layoutInflater.inflate(R.layout.product_view_holder,null);

        txtViewHol1 = productView.findViewById(R.id.txtViewHol1);
        txtViewHol2 = productView.findViewById(R.id.txtViewHol2);
        imgViewHolder = productView.findViewById(R.id.imgViewHolder);

        

        return new ProductViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product productToBeBound = productsArrayList.get(position);

        txtViewHol1 = holder.itemView.findViewById(R.id.txtViewHol1);
        txtViewHol2 = holder.itemView.findViewById(R.id.txtViewHol2);
        imgViewHolder = holder.itemView.findViewById(R.id.imgViewHolder);

        txtViewHol1.setText("" + productToBeBound.productTitle);
        txtViewHol2.setText(" " + productToBeBound.productPrice);
        imgViewHolder.setImageResource(R.drawable.ic_launcher_background);


    }

    @Override
    public int getItemCount() {
        return productsArrayList.size();
    }

}
