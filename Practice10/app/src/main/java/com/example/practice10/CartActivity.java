package com.example.practice10;

import static android.content.Intent.getIntent;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.OutputStream;
import java.util.Objects;

public class CartActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    public static String ONION = "";
    public static String O_QTY = "";
    public static String O_PRICE = "";

    public static String SOYBEAN = "";
    public static String S_QTY = "";
    public static String S_PRICE = "";

    public static String CHICKEN = "";
    public static String QTY = "";
    public static String PRICE = "";

    public static String EGG = "";
    public static String E_QTY = "";
    public static String E_PRICE = "";

    public static String POTATO = "";
    public static String POT_QTY = "";
    public static String POT_PRICE = "";

    public static String SOAP = "";
    public static String SOAP_QTY = "";
    public static String SOAP_PRICE = "";

    public static int TOTAL_QTY = 0;
    public static int TOTAL_PRICE = 0;






    TextView tQty,tPrice, oniName, oniQty, oniPrice,date,time;
    LinearLayout itemDetails, orderList;
    Button download,send;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        //serial = findViewById(R.id.serial);



//        This is the right way to do it
//        itemName = findViewById(R.id.itemName);
//        itemQty = findViewById(R.id.itemQty);
//        itemPrice = findViewById(R.id.itemPrice);

        oniName = findViewById(R.id.itemOni);
        oniQty = findViewById(R.id.oniQty);
        oniPrice = findViewById(R.id.oniPrice);

        tQty = findViewById(R.id.tQty);
        tPrice = findViewById(R.id.tPrice);

        date = findViewById(R.id.date);
        itemDetails = findViewById(R.id.itemDetails);
        download = findViewById(R.id.btnDown);
        send = findViewById(R.id.btnSend);
        orderList = findViewById(R.id.orderList);

        //time = findViewById(R.id.time);

        itemDetails.setVisibility(View.GONE);



        if (ONION!=null){

            itemDetails.setVisibility(View.VISIBLE);
            oniName.setText(ONION+"\n");
            oniQty.setText(O_QTY+"\n");
            oniPrice.setText(O_PRICE+"\n");

        } if(SOYBEAN!=null){
            itemDetails.setVisibility(View.VISIBLE);
            oniName.append(SOYBEAN+"\n");
            oniQty.append(S_QTY+"\n");
            oniPrice.append(S_PRICE+"\n");

        } if(CHICKEN!=null){
            itemDetails.setVisibility(View.VISIBLE);
            oniName.append(CHICKEN+"\n");
            oniQty.append(QTY+"\n");
            oniPrice.append(PRICE+"\n");

        } if(EGG!=null){
            itemDetails.setVisibility(View.VISIBLE);
            oniName.append(EGG+"\n");
            oniQty.append(E_QTY+"\n");
            oniPrice.append(E_PRICE+"\n");

        } if(POTATO!=null){
            itemDetails.setVisibility(View.VISIBLE);
            oniName.append(POTATO+"\n");
            oniQty.append(POT_QTY+"\n");
            oniPrice.append(POT_PRICE+"\n");

        } if(SOAP!=null){
            itemDetails.setVisibility(View.VISIBLE);
            oniName.append(SOAP+"\n");
            oniQty.append(SOAP_QTY+"\n");
            oniPrice.append(SOAP_PRICE+"\n");
        }







//        oniName.setText(ONION+"\n");
//        oniQty.setText(O_QTY+"\n");
//        oniPrice.setText(O_PRICE+"\n");


//        oniName.append(SOYBEAN+"\n");
//        oniQty.append(S_QTY+"\n");
//        oniPrice.append(S_PRICE+"\n");


//        oniName.append(CHICKEN+"\n");
//        oniQty.append(QTY+"\n");
//        oniPrice.append(PRICE+"\n");

//        oniName.append(EGG+"\n");
//        oniQty.append(E_QTY+"\n");
//        oniPrice.append(E_PRICE+"\n");

//        oniName.append(POTATO+"\n");
//        oniQty.append(POT_QTY+"\n");
//        oniPrice.append(POT_PRICE+"\n");

//        oniName.append(SOAP+"\n");
//        oniQty.append(SOAP_QTY+"\n");
//        oniPrice.append(SOAP_PRICE+"\n");


        tQty.setText(""+TOTAL_QTY);
        tPrice.setText(""+TOTAL_PRICE);


        String pDate = getIntent().getStringExtra("CLICK_TIMESTAMP");
        date.setText(pDate);






    }

}