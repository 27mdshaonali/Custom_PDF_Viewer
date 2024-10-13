package com.example.electricitybill;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.result);
        Button calculateButton = findViewById(R.id.calculate);
        EditText units = findViewById(R.id.unit);






        calculateButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String sUnits = units.getText().toString().trim();

                try{


                    if (sUnits.isEmpty()){
                        textView.setText("Result is Empty");
                        units.setError("Enter your consumed unit");

                    } else {
                        double dUnits = Double.parseDouble(sUnits);

                        if (dUnits <= 50){

                            double dBill = dUnits * 0.5;
                            //adding extra 20%
                            double extra = ((double) 20 /100)*dBill;
                            double extraAndBill = extra+dBill;
                            textView.setText("Your consumed unit is: " + dUnits + "\nYour electricity bill is: TK "+extraAndBill+ "\n\n*Per unit price is: 0.50 BDT and extra 20% is added" );

                        } else if(dUnits <= 150){

                            double dBill = (50*.50) + (dUnits-50)*.75;
                            //adding extra 20%
                            double extra = ((double) 20 /100)*dBill;
                            double extraAndBill = extra+dBill;
                            textView.setText("Your consumed unit is: " + dUnits + "\nYour electricity bill is: TK "+extraAndBill+ "\n\n*Per unit price is: 0.75 BDT and extra 20% is added");

                        } else if(dUnits <= 250){

                            double dBill = ( ((50*.5)+(100*.75)) + ((dUnits-150) *1.20));
                            //adding extra 20%
                            double extra = ((double) 20 /100)*dBill;
                            double extraAndBill = extra+dBill;
                            textView.setText("Your consumed unit is: " + dUnits + "\nYour electricity bill is: TK "+extraAndBill+ "\n\n*Per unit price is: 1.20 BDT and extra 20% is added");

                        } else if(dUnits > 250){

                            double dBill = ((50*.50) + (100*.75)+(100*1.20) + ((dUnits-250)*1.50));
                            //adding extra 20%
                            double extra = ((double) 20 /100)*dBill;
                            double extraAndBill = extra+dBill;
                            textView.setText("Your consumed unit is: " + dUnits + "\nYour electricity bill is: TK "+extraAndBill + "\n\n*Per unit price is: 1.50 BDT and extra 20% is added");

                        }





                    }



                    //Toast.makeText(MainActivity.this, "Calculating...", Toast.LENGTH_SHORT).show();

                } catch (Exception e){
                    e.printStackTrace();
                }


            }
        });

    }
}