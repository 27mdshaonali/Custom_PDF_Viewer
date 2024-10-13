package com.example.practice10;

import static com.example.practice10.R.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView onionPrice;
    public TextView soybeanPrice;
    public TextView chikenPrice;
    public TextView eggPrice;
    public TextView potatoPrice;
    public TextView soapPrice;
    public TextView totalPrice;
    public TextView itemCount;
    public Button onionAdd, soybeanAdd, chikenAdd, eggAdd, potatoAdd, soapAdd;
    public ImageView cart;

    int totalItems = 0;
    int tPrice = 0;

    int onion = 50;
    int soybean = 200;
    int chicken = 200;
    int egg = 48;
    int potato = 55;
    int soap = 45;

    int oP = 0;
    int sP = 0;
    int cP = 0;
    int eP = 0;
    int pP = 0;
    int soP = 0;


    int oTP = 0;
    int sTP = 0;
    int cTP = 0;
    int eTP = 0;
    int pTP = 0;
    int soTP = 0;



    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        onionPrice = findViewById(id.onionPrice);
        soybeanPrice = findViewById(id.soybeanPrice);
        chikenPrice = findViewById(id.chickenPrice);
        eggPrice = findViewById(id.eggPrice);
        potatoPrice = findViewById(id.potatoPrice);
        soapPrice = findViewById(id.soapPrice);

        onionAdd = findViewById(id.onionAdd);
        soybeanAdd = findViewById(id.soybeanAdd);
        chikenAdd = findViewById(id.chickenAdd);
        eggAdd = findViewById(id.eggAdd);
        potatoAdd = findViewById(id.potatoAdd);
        soapAdd = findViewById(id.soapAdd);

        cart = findViewById(id.cart);
        totalPrice = findViewById(id.totalPrice);
        itemCount = findViewById(id.itemCount);


        onionAdd.setOnClickListener(this);
        soybeanAdd.setOnClickListener(this);
        chikenAdd.setOnClickListener(this);
        eggAdd.setOnClickListener(this);
        potatoAdd.setOnClickListener(this);
        soapAdd.setOnClickListener(this);
        cart.setOnClickListener(this);




        onionPrice.setText("Price : " +onion+ " TK");
        soybeanPrice.setText("Price : " +soybean+ " TK");
        chikenPrice.setText("Price : " +chicken+ " TK");
        eggPrice.setText("Price : " +egg+ " TK");
        potatoPrice.setText("Price : " +potato+ " TK");
        soapPrice.setText("Price : " +soap+ " TK");





    }


    @Override
    public void onClick(View v) {


        int id = v.getId();

        if (id == R.id.onionAdd) {
            totalItems++;

            oP++;
            oTP = oP*onion;

            CartActivity.ONION = "Onion";
            CartActivity.O_QTY = ""+oP;
            CartActivity.O_PRICE = ""+oTP;
            updateQty();


        } else if(id == R.id.soybeanAdd){
            totalItems++;

            sP++;
            sTP = sP*soybean;

            CartActivity.SOYBEAN = "Soybean";
            CartActivity.S_QTY = ""+sP;
            CartActivity.S_PRICE = ""+sTP;
            updateQty();

        } else if(id == R.id.chickenAdd){
            totalItems++;
            cP++;
            cTP = cP*chicken;
            CartActivity.CHICKEN = "Chicken";
            CartActivity.QTY = ""+cP;
            CartActivity.PRICE = ""+cTP;
            updateQty();

        } else if(id == R.id.eggAdd){
            totalItems++;
            eP++;
            eTP = eP*egg;
            CartActivity.EGG = "Egg";
            CartActivity.E_QTY = ""+eP;
            CartActivity.E_PRICE = ""+eTP;
            updateQty();

        } else if(id == R.id.potatoAdd){
            totalItems++;
            pP++;
            pTP = pP*potato;
            CartActivity.POTATO = "Potato";
            CartActivity.POT_QTY = ""+pP;
            CartActivity.POT_PRICE = ""+pTP;
            updateQty();

        } else if(id == R.id.soapAdd){
            totalItems++;
            soP++;
            soTP = soP*soap;
            CartActivity.SOAP = "Soap";
            CartActivity.SOAP_QTY = ""+soP;
            CartActivity.SOAP_PRICE = ""+soTP;
            updateQty();

        } else if(id == R.id.cart){

            // Get current date and time
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy\nHH:mm:ss", Locale.getDefault());
            String currentDateTime = dateFormat.format(new Date());

            // Create Intent to start the second Activity
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            intent.putExtra("CLICKED_ITEM", id == R.id.cart);// Pass the clicked item ID
            intent.putExtra("CLICK_TIMESTAMP", currentDateTime);
            startActivity(intent);



        }



    }

    @SuppressLint("SetTextI18n")
    public void updateQty() {
        itemCount.setText(String.valueOf(totalItems));
        int pri = oTP+sTP+cTP+eTP+pTP+soTP;

        CartActivity.TOTAL_QTY = totalItems;
        CartActivity.TOTAL_PRICE = pri;

        totalPrice.setText(""+pri);

    }


}