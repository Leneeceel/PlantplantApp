package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Purchase extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
    }

    public void btnOK(View v)
    {
        Intent i = new Intent(Purchase.this, UserConfirm.class);
        i.putExtra("cardNo", 0);




        startActivity(i);
    }

    public void btnCancel(View v)
    {
        Intent i = new Intent(Purchase.this, UserCart.class);
        startActivity(i);
    }


}
