package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Purchase extends Activity
{
    final DatabaseManager dbManager = new DatabaseManager(this);
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    TableLayout latTableLayout;
    TableLayout.LayoutParams tableLayoutParam;

    ArrayList<Bitmap> images;

    int account_id;
    ArrayList<Integer> product_ids;

    int rowCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        latTableLayout = findViewById(R.id.latTableLayout);

        sharedPreferences = getSharedPreferences("sharedPreferences", 0);
//        editor = sharedPreferences.edit();
        images = getImages();
        account_id = sharedPreferences.getInt("id", 0);
        product_ids = dbManager.getProductIDs(account_id);
        generateCartItems();
    }

    void generateCartItems()
    {
        final List table = dbManager.getProducts();
        final List cart = dbManager.getCart(account_id);

        tableLayoutParam = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT);
        ArrayList<TableRow> rows = new ArrayList<>();
        int productIDCount = 0;

        for (final Object o : cart)
        {
            ArrayList row = (ArrayList) o;

            TextView textViewInRow = new TextView(this);
            ImageView imageViewInRow = new ImageView(this);

            StringBuilder nameAndPrice = new StringBuilder();

            //row.get(0) gets a name, row.get(1) gets a price
            nameAndPrice.append(row.get(0).toString());
            nameAndPrice.append("\t$ ");
            nameAndPrice.append(row.get(1).toString());

            //exception raises when getting an image
            textViewInRow.setText(nameAndPrice);
            textViewInRow.setTypeface(Typeface.DEFAULT_BOLD);
            imageViewInRow.setImageBitmap(images.get(product_ids.get(productIDCount)));
            productIDCount++;

            rows.add(new TableRow((this)));
            rows.get(rowCount).setLayoutParams(tableLayoutParam);

            rows.get(rowCount).addView(imageViewInRow);
            rows.get(rowCount).addView(textViewInRow);

            latTableLayout.addView(rows.get(rowCount));
            rowCount++;
        }
    }

    ArrayList<Bitmap> getImages()
    {
        ArrayList<Bitmap> images = new ArrayList<>();
        Bitmap img0 = BitmapFactory.decodeResource(getResources(), R.drawable.harry_potter);
        Bitmap img1 = BitmapFactory.decodeResource(getResources(), R.drawable.beginning_c_oop);
        Bitmap img2 = BitmapFactory.decodeResource(getResources(), R.drawable.pro_asp_dot_net_core_mvc_2);
        Bitmap img3 = BitmapFactory.decodeResource(getResources(), R.drawable.html_and_css_design_and_build_websites);
        Bitmap img4 = BitmapFactory.decodeResource(getResources(), R.drawable.debugging);
        Bitmap img5 = BitmapFactory.decodeResource(getResources(), R.drawable.software_quality_assurance);
        Bitmap img6 = BitmapFactory.decodeResource(getResources(), R.drawable.humidifier);
        Bitmap img7 = BitmapFactory.decodeResource(getResources(), R.drawable.dehumidifier);
        Bitmap img8 = BitmapFactory.decodeResource(getResources(), R.drawable.robot_vacuum);
        Bitmap img9 = BitmapFactory.decodeResource(getResources(), R.drawable.food_processor);
        Bitmap img10 = BitmapFactory.decodeResource(getResources(), R.drawable.toaster);
        Bitmap img11 = BitmapFactory.decodeResource(getResources(), R.drawable.fridge);
        Bitmap img12 = BitmapFactory.decodeResource(getResources(), R.drawable.couch);
        Bitmap img13 = BitmapFactory.decodeResource(getResources(), R.drawable.king_bed);
        Bitmap img14 = BitmapFactory.decodeResource(getResources(), R.drawable.table);
        Bitmap img15 = BitmapFactory.decodeResource(getResources(), R.drawable.chairs);
        Bitmap img16 = BitmapFactory.decodeResource(getResources(), R.drawable.sofa);
        Bitmap img17 = BitmapFactory.decodeResource(getResources(), R.drawable.king_sofa);
        Bitmap img18 = BitmapFactory.decodeResource(getResources(), R.drawable.samsung_phone);
        Bitmap img19 = BitmapFactory.decodeResource(getResources(), R.drawable.pixel_3);
        Bitmap img20 = BitmapFactory.decodeResource(getResources(), R.drawable.iphone);
        Bitmap img21 = BitmapFactory.decodeResource(getResources(), R.drawable.pixel_2);
        Bitmap img22 = BitmapFactory.decodeResource(getResources(), R.drawable.pixel_1);
        Bitmap img23 = BitmapFactory.decodeResource(getResources(), R.drawable.pixel_0);
        Bitmap img24 = BitmapFactory.decodeResource(getResources(), R.drawable.vitamins);
        Bitmap img25 = BitmapFactory.decodeResource(getResources(), R.drawable.vitality);
        Bitmap img26 = BitmapFactory.decodeResource(getResources(), R.drawable.digestives);
        Bitmap img27 = BitmapFactory.decodeResource(getResources(), R.drawable.cannabis_oil);
        Bitmap img28 = BitmapFactory.decodeResource(getResources(), R.drawable.digest_t);
        Bitmap img29 = BitmapFactory.decodeResource(getResources(), R.drawable.vitamin_d3);

        Bitmap scaled0 = Bitmap.createScaledBitmap(img0, 300, 300, true);
        Bitmap scaled1 = Bitmap.createScaledBitmap(img1, 300, 300, true);
        Bitmap scaled2 = Bitmap.createScaledBitmap(img2, 300, 300, true);
        Bitmap scaled3 = Bitmap.createScaledBitmap(img3, 300, 300, true);
        Bitmap scaled4 = Bitmap.createScaledBitmap(img4, 300, 300, true);
        Bitmap scaled5 = Bitmap.createScaledBitmap(img5, 300, 300, true);
        Bitmap scaled6 = Bitmap.createScaledBitmap(img6, 300, 300, true);
        Bitmap scaled7 = Bitmap.createScaledBitmap(img7, 300, 300, true);
        Bitmap scaled8 = Bitmap.createScaledBitmap(img8, 300, 300, true);
        Bitmap scaled9 = Bitmap.createScaledBitmap(img9, 300, 300, true);
        Bitmap scaled10 = Bitmap.createScaledBitmap(img10, 300, 300, true);
        Bitmap scaled11 = Bitmap.createScaledBitmap(img11, 300, 300, true);
        Bitmap scaled12 = Bitmap.createScaledBitmap(img12, 300, 300, true);
        Bitmap scaled13 = Bitmap.createScaledBitmap(img13, 300, 300, true);
        Bitmap scaled14 = Bitmap.createScaledBitmap(img14, 300, 300, true);
        Bitmap scaled15 = Bitmap.createScaledBitmap(img15, 300, 300, true);
        Bitmap scaled16 = Bitmap.createScaledBitmap(img16, 300, 300, true);
        Bitmap scaled17 = Bitmap.createScaledBitmap(img17, 300, 300, true);
        Bitmap scaled18 = Bitmap.createScaledBitmap(img18, 300, 300, true);
        Bitmap scaled19 = Bitmap.createScaledBitmap(img19, 300, 300, true);
        Bitmap scaled20 = Bitmap.createScaledBitmap(img20, 300, 300, true);
        Bitmap scaled21 = Bitmap.createScaledBitmap(img21, 300, 300, true);
        Bitmap scaled22 = Bitmap.createScaledBitmap(img22, 300, 300, true);
        Bitmap scaled23 = Bitmap.createScaledBitmap(img23, 300, 300, true);
        Bitmap scaled24 = Bitmap.createScaledBitmap(img24, 300, 300, true);
        Bitmap scaled25 = Bitmap.createScaledBitmap(img25, 300, 300, true);
        Bitmap scaled26 = Bitmap.createScaledBitmap(img26, 300, 300, true);
        Bitmap scaled27 = Bitmap.createScaledBitmap(img27, 300, 300, true);
        Bitmap scaled28 = Bitmap.createScaledBitmap(img28, 300, 300, true);
        Bitmap scaled29 = Bitmap.createScaledBitmap(img29, 300, 300, true);

        images.add(scaled0);
        images.add(scaled1);
        images.add(scaled2);
        images.add(scaled3);
        images.add(scaled4);
        images.add(scaled5);
        images.add(scaled6);
        images.add(scaled7);
        images.add(scaled8);
        images.add(scaled9);
        images.add(scaled10);
        images.add(scaled11);
        images.add(scaled12);
        images.add(scaled13);
        images.add(scaled14);
        images.add(scaled15);
        images.add(scaled16);
        images.add(scaled17);
        images.add(scaled18);
        images.add(scaled19);
        images.add(scaled20);
        images.add(scaled21);
        images.add(scaled22);
        images.add(scaled23);
        images.add(scaled24);
        images.add(scaled25);
        images.add(scaled26);
        images.add(scaled27);
        images.add(scaled28);
        images.add(scaled29);

        return images;
    }
}
