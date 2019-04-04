package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddProductActivity extends Activity {

    final DatabaseManager dbManager = new DatabaseManager(this);

    ArrayList<String> newProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        Intent intent = getIntent();

        EditText nameInput = (EditText) findViewById(R.id.nameEditText);
        EditText priceInput = (EditText) findViewById(R.id.priceEditText);
        EditText desInput = (EditText) findViewById(R.id.desEditText);
        EditText stockInput = (EditText) findViewById(R.id.stockEditText);
        Spinner cateogorySpinner = (Spinner) findViewById(R.id.categorySpinner);

    }
    void addProduct() {

    }
}
