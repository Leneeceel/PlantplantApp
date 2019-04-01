package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserMain extends Activity
{
    final DatabaseManager dbManager = new DatabaseManager(this);
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Intent i;

    TextView txtWelcome;

    String fName, lName, address, city, province;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        txtWelcome = findViewById(R.id.txtWelcome);
        sharedPreferences = getSharedPreferences("sharedPreferences", 0);

        fName = sharedPreferences.getString("fName", null);
        lName = sharedPreferences.getString("lName", null);
        address = sharedPreferences.getString("address", null);
        city = sharedPreferences.getString("city", null);
        province = sharedPreferences.getString("province", null);

        String userInfoDisplay = "Welcome, " + fName + " " + lName + "!\n"
                + address + ", " + city + ", " + province;

        txtWelcome.setText(userInfoDisplay);
    }

    public void btnShopping(View v)
    {
        Intent i = new Intent(UserMain.this, Shopping.class);
        startActivity(i);
    }
    public void btnUpdate(View v)
    {
        Intent i = new Intent(UserMain.this, UserUpdate.class);
        startActivity(i);
    }
    public void btnLogOut(View v)
    {

    }
}
