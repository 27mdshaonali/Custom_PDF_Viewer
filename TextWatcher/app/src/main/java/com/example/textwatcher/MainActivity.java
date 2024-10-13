package com.example.textwatcher;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText barcode;

    TextView product_name,product_price;

    Button submit, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        barcode = findViewById(R.id.barcode);
        product_name = findViewById(R.id.product_name);
        product_price = findViewById(R.id.product_price);
        submit = findViewById(R.id.submit);
        clear = findViewById(R.id.clear);





        barcode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {




            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                String sBarcode = barcode.getText().toString().trim();


                if (sBarcode.equals("10")){
                    product_name.setText("Product: Formal Shirt");
                    product_price.setText("Price: 1990 TK");
                } else if(sBarcode.equals("11")){

                    product_name.setText("Product: T-Shirt");
                    product_price.setText("Price: 1500 TK");

                } else if(sBarcode.equals("12")){

                    product_name.setText("Product: Jeans");
                    product_price.setText("Price: 2500 TK");

                } else {
                    product_name.setText("Product: N/A");
                    product_price.setText("Price: N/A");
                    barcode.clearFocus();

                }



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sBarcode = barcode.getText().toString();

                if (!sBarcode.isEmpty()){
                    barcode.clearFocus();

                } else {
                    barcode.setError("Enter a Barcode!");


                }

            }
        });




    }
}