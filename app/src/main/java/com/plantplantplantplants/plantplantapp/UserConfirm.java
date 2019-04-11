package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserConfirm extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_confirm);
    }

    public void backToShopping(View v)
    {
        Intent i = new Intent(UserConfirm.this, Shopping.class);
        startActivity(i);
    }
}
