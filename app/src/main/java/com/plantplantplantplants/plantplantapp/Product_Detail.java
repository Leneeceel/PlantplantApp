package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Product_Detail extends Activity
{
    final DatabaseManager dbManager = new DatabaseManager(this);

    Intent i;
    TextView txtNamePrice, txtDesc;
    TableLayout latTableLayout;

    int product_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__detail);
        txtNamePrice = findViewById(R.id.txtNamePrice);
        txtDesc = findViewById(R.id.txtDesc);
        latTableLayout = findViewById(R.id.latTableLayout);

        getProductDetail();
    }

    void getProductDetail()
    {
        i = getIntent();
        product_id = i.getIntExtra("product_id", 0);

        //Index starts with 1 in a table
        ArrayList<String> productInfo = dbManager.getProductByID((product_id+1));
        //productInfo index 0 = name, 1 = price, 2 = category, 3 = description, 4 = stock

        txtNamePrice.setText(productInfo.get(2) + "\n" + productInfo.get(0) + "\n" + productInfo.get(1) +
                "\n" + productInfo.get(4) + " left!");
        txtDesc.setText(productInfo.get(3));
    }
}
