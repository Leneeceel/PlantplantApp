package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        dbManager.createTables(tables, statements);
        dbManager.populateSeedData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
