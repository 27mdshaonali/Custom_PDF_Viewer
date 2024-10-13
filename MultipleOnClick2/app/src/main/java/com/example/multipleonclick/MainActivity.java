package com.example.multipleonclick;

import static android.widget.Toast.LENGTH_SHORT;

import android.annotation.SuppressLint;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {


    int totalItems = 0;
    int totalPrices = 0;

    private TextView onionPrice, soybeanPrice, chikenPrice, eggPrice, potatoPrice, soapPrice, totalPrice, itemCount;
    private Button onionAdd, soybeanAdd, chikenAdd, eggAdd, potatoAdd, soapAdd;
    private ImageView cart;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        onionPrice = findViewById(R.id.onionPrice);
        soybeanPrice = findViewById(R.id.soybeanPrice);
        chikenPrice = findViewById(R.id.chikenPrice);
        eggPrice = findViewById(R.id.eggPrice);
        potatoPrice = findViewById(R.id.potatoPrice);
        soapPrice = findViewById(R.id.soapPrice);

        onionAdd = findViewById(R.id.onionAdd);
        soybeanAdd = findViewById(R.id.soybeanAdd);
        chikenAdd = findViewById(R.id.chikenAdd);
        eggAdd = findViewById(R.id.eggAdd);
        potatoAdd = findViewById(R.id.potatoAdd);
        soapAdd = findViewById(R.id.soapAdd);

        cart = findViewById(R.id.cart);
        totalPrice = findViewById(R.id.totalPrice);
        itemCount = findViewById(R.id.itemCount);




        View.OnClickListener onClickListener = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {


                int id = view.getId();



                if (id == R.id.onionAdd)
                {
                    totalItems++;
                    totalPrices += 60;
                    itemCount.setText(String.valueOf(totalItems));
                    totalPrice.setText(String.valueOf(totalPrices));
                    Toast.makeText(MainActivity.this, "Onion Added", LENGTH_SHORT).show();
                }

                else if(id == R.id.soybeanAdd){
                    totalItems++;
                    totalPrices += 200;
                    itemCount.setText(String.valueOf(totalItems));
                    totalPrice.setText(String.valueOf(totalPrices));
                    Toast.makeText(MainActivity.this, "Soybean Added", LENGTH_SHORT).show();

                }
                else if(id == R.id.chikenAdd){
                    totalItems++;
                    totalPrices += 200;
                    itemCount.setText(String.valueOf(totalItems));
                    totalPrice.setText(String.valueOf(totalPrices));
                    Toast.makeText(MainActivity.this, "Chicken Added", LENGTH_SHORT).show();

                }

                else if(id == R.id.eggAdd){
                    totalItems++;
                    totalPrices += 48;
                    itemCount.setText(String.valueOf(totalItems));
                    totalPrice.setText(String.valueOf(totalPrices));
                    Toast.makeText(MainActivity.this, "Egg Added", LENGTH_SHORT).show();

                }

                else if(id == R.id.potatoAdd){
                    totalItems++;
                    totalPrices += 55;
                    itemCount.setText(String.valueOf(totalItems));
                    totalPrice.setText(String.valueOf(totalPrices));
                    Toast.makeText(MainActivity.this, "Potato Added", LENGTH_SHORT).show();

                }

                else if(id == R.id.soapAdd){
                    totalItems++;
                    totalPrices += 45;
                    itemCount.setText(String.valueOf(totalItems));
                    totalPrice.setText(String.valueOf(totalPrices));
                    Toast.makeText(MainActivity.this, "Soap Added", LENGTH_SHORT).show();

                }

                else if(id == R.id.cart){
                    Toast.makeText(MainActivity.this, "Cart", LENGTH_SHORT).show();
                }



            }

        };



        onionAdd.setOnClickListener(onClickListener);
        soybeanAdd.setOnClickListener(onClickListener);
        chikenAdd.setOnClickListener(onClickListener);
        eggAdd.setOnClickListener(onClickListener);
        potatoAdd.setOnClickListener(onClickListener);
        soapAdd.setOnClickListener(onClickListener);






    }


}