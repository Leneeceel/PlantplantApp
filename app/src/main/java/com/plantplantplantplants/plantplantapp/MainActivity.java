package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    final DatabaseManager dbManager = new DatabaseManager(this);
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

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

    RadioGroup rdgIdtype;
    RadioButton rdbAdmin,
                rdbUser;

    Button btnLogin;


    String userName,
            password;

    boolean isUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        dbManager.createTables(tables, statements);
        dbManager.populateSeedData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        rdgIdtype = findViewById(R.id.rdgIdtype);
        btnLogin = findViewById(R.id.btnLogIn);
        btnLogin.setEnabled(false);
        rdbAdmin = findViewById(R.id.rdbAdmin);
        rdbUser = findViewById(R.id.rdbUser);

        //Radio button setting
        radioGroupSetting();

    }

    public void btnLogIn(View v)
    {
        userName = edtUserName.getText().toString();
        password = edtPassword.getText().toString();

        //Login validation
        if (dbManager.logInValidation(userName, password, isUser))
        {
            messageDisplay("Login Successful.");

            Intent i = new Intent(MainActivity.this, UserMain.class);
            sharedPreferences = getSharedPreferences("sharedPreferences", 0);
            editor = sharedPreferences.edit();

            String[] userInfo = dbManager.getUserInfo(userName);

            editor.putString("fName", userInfo[3]);
            editor.putString("lName", userInfo[4]);
            editor.putString("address", userInfo[5]);
            editor.putString("city", userInfo[6]);
            editor.putString("province", userInfo[7]);
            editor.commit();

            startActivity(i);
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

    void radioGroupSetting()
    {
        rdgIdtype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if (rdbAdmin.isChecked())
                {
                    btnLogin.setEnabled(true);
                    isUser = false;
                }
                else if (rdbUser.isChecked())
                {
                    btnLogin.setEnabled(true);
                    isUser = true;
                }
            }
        });
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
