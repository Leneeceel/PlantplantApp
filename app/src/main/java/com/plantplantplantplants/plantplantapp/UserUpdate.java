package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserUpdate extends Activity
{
    final DatabaseManager dbManager = new DatabaseManager(this);
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    EditText edtFName, edtLName, edtAddress, edtCity, edtProvince;
    String fName, lName, address, city, province;

    Account updatedInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);

        sharedPreferences = getSharedPreferences("sharedPreferences", 0);
        editor = sharedPreferences.edit();

        edtFName = findViewById(R.id.edtFName);
        edtLName = findViewById(R.id.edtLName);
        edtAddress = findViewById(R.id.edtAddress);
        edtCity = findViewById(R.id.edtCity);
        edtProvince = findViewById(R.id.edtProvince);

        updatedInfo = new Account();

        setEditText();
    }

    public void btnUpdate(View v)
    {
        fName = edtFName.getText().toString();
        lName = edtLName.getText().toString();
        address = edtAddress.getText().toString();
        city = edtCity.getText().toString();
        province = edtProvince.getText().toString();

        ContentValues contentValues = new ContentValues();

        updatedInfo.records = dbManager.getUserInfo(sharedPreferences.getInt("id", 0));

        updatedInfo.records[3] = fName;
        updatedInfo.records[4] = lName;
        updatedInfo.records[5] = address;
        updatedInfo.records[6] = city;
        updatedInfo.records[7] = province;

        dbManager.updateInfo(contentValues, "tbl_account", updatedInfo.field, updatedInfo.records);
        editor.putString("fName", fName);
        editor.putString("lName", lName);
        editor.putString("address", address);
        editor.putString("city", city);
        editor.putString("province", province);
        editor.commit();
        messageDisplay("User Info Updated Successfully");

        backToMain();
    }

    public void btnCancel(View v)
    {
        backToMain();
    }

    //populate edit texts with existing user info
    void setEditText()
    {
        fName = sharedPreferences.getString("fName", null);
        lName = sharedPreferences.getString("lName", null);
        address = sharedPreferences.getString("address", null);
        city = sharedPreferences.getString("city", null);
        province = sharedPreferences.getString("province", null);

        edtFName.setText(fName);
        edtLName.setText(lName);
        edtAddress.setText(address);
        edtCity.setText(city);
        edtProvince.setText(province);
    }

    void backToMain()
    {
        Intent i = new Intent(UserUpdate.this, UserMain.class);
        startActivity(i);
    }

    void messageDisplay(String st)
    {
        Toast toast = Toast.makeText(getApplicationContext(),
                st,
                Toast.LENGTH_LONG);
        toast.show();
    }
}
