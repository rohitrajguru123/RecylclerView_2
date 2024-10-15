package com.example.recylclerview_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {
    ImageView imgView;
    TextView txtView1,txtView2;
    int pId,pImage;
    String pTitle,pPrice;
    Product product;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        initViews();
        extactDataAndBindingWithViews();
    }
    private void initViews(){
        imgView = findViewById(R.id.imgView);
        txtView1 = findViewById(R.id.txtView1);
        txtView2 = findViewById(R.id.txtView2);

    }
    private void extactDataAndBindingWithViews(){
        Intent intent = getIntent();
        //way 1
//       pId = intent.getIntExtra("productId",10);
//       pTitle = intent.getStringExtra("productTitle");
//       pImage = intent.getIntExtra("productImage",-1);
//       pPrice = intent.getStringExtra("productPrice");
//
//       imgView.setImageResource(pImage);
//       txtView1.setText(pTitle);
//       txtView2.setText(pPrice);
        //way 2
        product = (Product) intent.getSerializableExtra("product");
        imgView.setImageResource(product.productImage);
        txtView1.setText(product.productTitle);
        txtView2.setText(product.productPrice);
    }
}
