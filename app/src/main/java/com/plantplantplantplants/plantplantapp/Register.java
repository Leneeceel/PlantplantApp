package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity
{
    final DatabaseManager dbManager = new DatabaseManager(this);

    String userName, password, fName, lName,
            address, city, province;

    EditText edtUserName, edtPassword, edtFName, edtLName,
            edtAddress, edtCity, edtProvince;

    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        edtFName = findViewById(R.id.edtFName);
        edtLName = findViewById(R.id.edtLName);
        edtAddress = findViewById(R.id.edtAddress);
        edtCity = findViewById(R.id.edtCity);
        edtProvince = findViewById(R.id.edtProvince);

    }

    public void btnRegister(View v)
    {
        userName = edtUserName.getText().toString();
        password = edtPassword.getText().toString();
        fName = edtFName.getText().toString();
        lName = edtLName.getText().toString();
        address = edtAddress.getText().toString();
        city = edtCity.getText().toString();
        province = edtProvince.getText().toString();

        account = new Account();

        account.records[1] = userName;
        account.records[2] = password;
        account.records[3] = fName;
        account.records[4] = lName;
        account.records[5] = address;
        account.records[6] = city;
        account.records[7] = province;
        account.records[8] = "U";

        ContentValues contentValues = new ContentValues();

        dbManager.addRecord(contentValues, "tbl_account", account.field, account.records);

        messageDisplay("Registration Successful.");

        moveToMain();
    }

    public void btnCancel(View v)
    {
        messageDisplay("Registration Cancelled.");
        moveToMain();
    }

    //Display a parameter value as a toast message
    void messageDisplay(String st)
    {
        Toast toast = Toast.makeText(getApplicationContext(),
                st,
                Toast.LENGTH_LONG);
        toast.show();
    }

    void moveToMain()
    {
        Intent i = new Intent(Register.this, MainActivity.class);
        startActivity(i);
    }
}
