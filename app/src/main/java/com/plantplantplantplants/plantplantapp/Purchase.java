package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.getInstance;

public class Purchase extends Activity
{
    final DatabaseManager dbManager = new DatabaseManager(this);
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        sharedPreferences = getSharedPreferences("sharedPreferneces", 0);
//        editor = sharedPreferences.edit();
    }

    public void btnOK(View v)
    {
        Intent i = new Intent(Purchase.this, UserConfirm.class);
        i.putExtra("cardNo", 0);

        //"order_id", "account_id", "cart_id", "orderDate"
        ContentValues contentValues = new ContentValues();
        Order order = new Order();

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        String currDate = dateFormat.format(date).toString();

        int account_id = sharedPreferences.getInt("id", 0);
        int cart_id = sharedPreferences.getInt("cart_id", 0);

        order.records[1] = String.valueOf(account_id);
        order.records[2] = String.valueOf(cart_id);
        order.records[3] = currDate;
        dbManager.addRecord(contentValues, "tbl_order", order.field, order.records);

        startActivity(i);
    }

    public void btnCancel(View v)
    {
        Intent i = new Intent(Purchase.this, UserCart.class);
        startActivity(i);
    }


}
