package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminUpdateActivity extends Activity
{
    final DatabaseManager dbManager = new DatabaseManager(this);

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ArrayList<String> productInfo;
    int product_id;

    EditText productName, productPrice, productDescription, productStock, productCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update);

        productName = findViewById(R.id.pName);
        productPrice = findViewById(R.id.price);
        productDescription = findViewById(R.id.descripition);
        productStock = findViewById(R.id.stock);
        productCategory = findViewById(R.id.category);


        Intent i = getIntent();

        product_id = i.getIntExtra("product_id",0);
        productInfo = dbManager.getProductByID(product_id+1);
        //productInfo index 0 = name, 1 = price, 2 = category, 3 = description, 4 = stock
        productName.setText(productInfo.get(0));
        productPrice.setText(productInfo.get(1));
        productCategory.setText(productInfo.get(2));
        productDescription.setText(productInfo.get(3));
        productDescription.setText(productInfo.get(4));
    }
    public void updateBtnClicked(View v){
        String[] records = new String[6];
        String[] fields = Product.field.clone();

        records[0] = Integer.toString(product_id);
        records[1] = productName.getText().toString();
        records[2] = productPrice.getText().toString();
        records[3] = productCategory.getText().toString();
        records[4] = productDescription.getText().toString();
        records[5] = productStock.getText().toString();

        ContentValues values = new ContentValues();

        dbManager.updateInfo(values, "tbl_product", fields, records);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Product successfully changed",
                Toast.LENGTH_LONG);
        toast.show();


    }

    public void cancelBtnClicked(View v){
        Intent i = new Intent(this, AdminMain.class);
        startActivity(i);
    }
}
