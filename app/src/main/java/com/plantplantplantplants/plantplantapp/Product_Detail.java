package com.plantplantplantplants.plantplantapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Product_Detail extends Activity
{
    final DatabaseManager dbManager = new DatabaseManager(this);

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Intent i;
    TextView txtNamePrice, txtDesc;
    TableLayout latTableLayout;
    ImageView imgImage;

    ArrayList<String> productInfo;
    ArrayList<Integer> cart;

    int product_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__detail);
        sharedPreferences = getSharedPreferences("sharedPreferences", 0);
        editor = sharedPreferences.edit();

        txtNamePrice = findViewById(R.id.txtNamePrice);
        txtDesc = findViewById(R.id.txtDesc);
        latTableLayout = findViewById(R.id.latTableLayout);
        imgImage = findViewById(R.id.imgImage);

        getProductDetail();
    }

    void getProductDetail()
    {
        i = getIntent();
        product_id = i.getIntExtra("product_id", 0);

        //Index starts with 1 in a table
        productInfo = dbManager.getProductByID((product_id+1));
        //productInfo index 0 = name, 1 = price, 2 = category, 3 = description, 4 = stock

        txtNamePrice.setText(productInfo.get(2) + "\n" + productInfo.get(0) + "\n" + productInfo.get(1) +
                "\n" + productInfo.get(4) + " left!");
        txtDesc.setText(productInfo.get(3));

        ArrayList<Bitmap> images = getImages();
        imgImage.setImageBitmap(images.get(product_id));

        editor.putInt("product_Id", product_id);
    }
    public void btnBuyNow(View v)
    {
        Intent I = new Intent(Product_Detail.this, Purchase.class);
        startActivity(i);
    }

    public void btnBackToShopping(View v)
    {
        Intent i = new Intent(Product_Detail.this, Shopping.class);
        startActivity(i);
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

        Bitmap scaled0 = Bitmap.createScaledBitmap(img0, 500, 500, true);
        Bitmap scaled1 = Bitmap.createScaledBitmap(img1, 500, 500, true);
        Bitmap scaled2 = Bitmap.createScaledBitmap(img2, 500, 500, true);
        Bitmap scaled3 = Bitmap.createScaledBitmap(img3, 500, 500, true);
        Bitmap scaled4 = Bitmap.createScaledBitmap(img4, 500, 500, true);
        Bitmap scaled5 = Bitmap.createScaledBitmap(img5, 500, 500, true);
        Bitmap scaled6 = Bitmap.createScaledBitmap(img6, 500, 500, true);
        Bitmap scaled7 = Bitmap.createScaledBitmap(img7, 500, 500, true);
        Bitmap scaled8 = Bitmap.createScaledBitmap(img8, 500, 500, true);
        Bitmap scaled9 = Bitmap.createScaledBitmap(img9, 500, 500, true);
        Bitmap scaled10 = Bitmap.createScaledBitmap(img10, 500, 500, true);
        Bitmap scaled11 = Bitmap.createScaledBitmap(img11, 500, 500, true);
        Bitmap scaled12 = Bitmap.createScaledBitmap(img12, 500, 500, true);
        Bitmap scaled13 = Bitmap.createScaledBitmap(img13, 500, 500, true);
        Bitmap scaled14 = Bitmap.createScaledBitmap(img14, 500, 500, true);
        Bitmap scaled15 = Bitmap.createScaledBitmap(img15, 500, 500, true);
        Bitmap scaled16 = Bitmap.createScaledBitmap(img16, 500, 500, true);
        Bitmap scaled17 = Bitmap.createScaledBitmap(img17, 500, 500, true);
        Bitmap scaled18 = Bitmap.createScaledBitmap(img18, 500, 500, true);
        Bitmap scaled19 = Bitmap.createScaledBitmap(img19, 500, 500, true);
        Bitmap scaled20 = Bitmap.createScaledBitmap(img20, 500, 500, true);
        Bitmap scaled21 = Bitmap.createScaledBitmap(img21, 500, 500, true);
        Bitmap scaled22 = Bitmap.createScaledBitmap(img22, 500, 500, true);
        Bitmap scaled23 = Bitmap.createScaledBitmap(img23, 500, 500, true);
        Bitmap scaled24 = Bitmap.createScaledBitmap(img24, 500, 500, true);
        Bitmap scaled25 = Bitmap.createScaledBitmap(img25, 500, 500, true);
        Bitmap scaled26 = Bitmap.createScaledBitmap(img26, 500, 500, true);
        Bitmap scaled27 = Bitmap.createScaledBitmap(img27, 500, 500, true);
        Bitmap scaled28 = Bitmap.createScaledBitmap(img28, 500, 500, true);
        Bitmap scaled29 = Bitmap.createScaledBitmap(img29, 500, 500, true);

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
