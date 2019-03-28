package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{
    final DatabaseManager dbManager = new DatabaseManager(this);

    //table names and statements
    String[] tables = {"tbl_account", "tbl_product", "tbl_order", "tbl_cart"};
    String[] statements =
           {"create table tbl_account " +
                    "(account_id integer primary key autoincrement," +
                    " userName text," +
                    " password text," +
                    " fName text," +
                    " lName text," +
                    " address text," +
                    " city text," +
                    " province text," +
                    " type text);",
            "create table tbl_product " +
                    "(product_id integer primary key autoincrement, " +
                    " name text," +
                    " price double," +
                    " category text," +
                    " description text," +
                    " stock integer);",
            "create table tbl_order " +
                    "(order_id integer primary key autoincrement, " +
                    " account_id integer," +
                    " cart_id text," +
                    " orderDate text);",
            "create table tbl_cart " +
                    "(cart_id integer primary key autoincrement, " +
                    " product_id integer," +
                    " account_id integer," +
                    " total double,"+
                    " quantity integer);"};

    EditText edtUserName,
            edtPassword;

    String userName,
            password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        dbManager.createTables(tables, statements);
        dbManager.populateSeedData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnLogIn(View v)
    {
        userName = edtUserName.getText().toString();
        password = edtPassword.getText().toString();

        if (dbManager.logInValidation(userName, password))
        {
            messageDisplay("Login Successful.");
        }
        else
        {
            messageDisplay("Login Failed.");
        }

    }

    public void btnRegister(View v)
    {
        Intent i = new Intent(MainActivity.this, Register.class);
        startActivity(i);
    }

    //Display a parameter value as a toast message
    void messageDisplay(String st)
    {
        Toast toast = Toast.makeText(getApplicationContext(),
                st,
                Toast.LENGTH_LONG);
        toast.show();
    }


}
