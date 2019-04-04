package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        Button addProductBtn = (Button) findViewById(R.id.addProductBtn);
        Button updateProductBtn = (Button) findViewById(R.id.updateProductBtn);
        Button viewOrdersBtn = (Button) findViewById(R.id.viewOrdersBtn);
    }

    public void addClicked(View v) {
        Intent intent = new Intent(this, AddProductActivity.class);
        startActivity(intent);
    }

    public void updateClicked(View v){
        Intent intent = new Intent(this, AdminProductListActivity.class);
        startActivity(intent);
    }

    public void viewOrdersClicked(View v) {
        Intent intent = new Intent(this, AdminOrdersActivity.class);
        startActivity(intent);
    }
}
