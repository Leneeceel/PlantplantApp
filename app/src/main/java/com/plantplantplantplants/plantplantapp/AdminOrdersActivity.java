package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdminOrdersActivity extends Activity
{
    ArrayList<String> orderInfo;
    final DatabaseManager dbManager = new DatabaseManager(this);
    TableLayout latTableLayout;
    TableLayout.LayoutParams tableLayoutParam;
    int rowCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_orders);
        latTableLayout = findViewById(R.id.latTableLayout);
        generateOrders();
    }

    public void generateOrders()
    {
        final List table = dbManager.getTable("tbl_order");
        tableLayoutParam = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT);
        ArrayList<TableRow> rows = new ArrayList<>();
        rowCount = 0;
        for (final Object o : table)
        {
            ArrayList row = (ArrayList) o;
            ArrayList<TextView> textViewsInRow = new ArrayList<>();
            for (int i=0;i<row.size();i++)
            {
                textViewsInRow.add(new TextView(this));
                textViewsInRow.get(i).setGravity(Gravity.CENTER);
                textViewsInRow.get(i).setText(row.get(i).toString());
            }

            View.OnClickListener textViewOnClickListener = new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int order_id = table.indexOf(o)+1;

                    orderInfo = dbManager.getOrderByID(order_id);
                    //orderInfo index 0 = account_id, 1 = cart_id, 2 = orderDate, 3 = status

                    String[] records = new String[5];
                    String[] fields = Order.field.clone();

                    records[0] = Integer.toString(order_id);
                    records[1] = orderInfo.get(0);
                    records[2] = orderInfo.get(1);
                    records[3] = orderInfo.get(2);
                    records[4] = "Confirmed";

                    ContentValues values = new ContentValues();

                    dbManager.updateOrderStatus(values,"tbl_order",fields,records);

                    messageDisplay("Product successfully changed");

                    //refresh the current activity
                    finish();
                    startActivity(getIntent());

                }
            };

            rows.add(new TableRow((this)));
            rows.get(rowCount).setLayoutParams(tableLayoutParam);
            for (int i = 0; i < textViewsInRow.size(); i++)
            {
                rows.get(rowCount).addView(textViewsInRow.get(i));
            }

            //If the status is confirmed, show the cancel button
//            if (row.get(7).toString().equals("Confirmed"))
//            {
//                changeStatus = setOnClickOnCancelButton(Integer.parseInt((row.get(1)).toString()));
//                rows.get(rowCount).addView(changeStatus);
//            }

//            latTableLayout.addView(rows.get(rowCount), (rowCount+1));
            latTableLayout.addView(rows.get(rowCount));
            rowCount++;

//            textViewInRow.setOnClickListener(textViewOnClickListener);
//
//            StringBuilder orders = new StringBuilder();
//
//            //row.get(0) gets a name, row.get(1) gets a price
//            orders.append(row.get(0).toString());
//            orders.append("\n$ ");
//            orders.append(row.get(1).toString());
//
//
//            textViewInRow.setText(orders);
//            textViewInRow.setTypeface(Typeface.DEFAULT_BOLD);
//
//
//            rows.add(new TableRow((this)));
//            rows.get(rowCount).setLayoutParams(tableLayoutParam);
//
//            rows.get(rowCount).addView(textViewInRow);
//
//            latTableLayout.addView(rows.get(rowCount));
//            rowCount++;
        }
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
