package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddProductActivity extends Activity {

    final DatabaseManager dbManager = new DatabaseManager(this);

    ArrayList<String> newProduct;

    EditText nameInput;
    EditText priceInput;
    EditText desInput;
    EditText stockInput;
    EditText categoryInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        Intent intent = getIntent();

        nameInput = findViewById(R.id.nameEditText);
        priceInput = findViewById(R.id.priceEditText);
        desInput = findViewById(R.id.desEditText);
        stockInput = findViewById(R.id.stockEditText);
//        categoryInput = findViewById(R.id.category);

    }
    private void addProduct(View v) {


        Product product = new Product();
        product.records[1] = nameInput.getText().toString();
        product.records[2] = priceInput.getText().toString();
        product.records[3] = categoryInput.getText().toString();
        product.records[4] = desInput.getText().toString();
        product.records[5] = stockInput.getText().toString();

        ContentValues values = new ContentValues();
        dbManager.addRecord(values,"tbl_product", product.field,product.records);

        Toast toast = Toast.makeText(getApplicationContext(),
                "New product successfully added",
                Toast.LENGTH_LONG);
        toast.show();

        Intent i = new Intent(this, AdminMain.class);
        startActivity(i);
    }
}
