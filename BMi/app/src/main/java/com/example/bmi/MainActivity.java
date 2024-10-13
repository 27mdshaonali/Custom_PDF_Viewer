package com.example.bmi;

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

    EditText weight, feet, inches;
    Button btnCalculate;
    TextView txtResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        weight = findViewById(R.id.weight);
        feet = findViewById(R.id.feet);
        inches = findViewById(R.id.inches);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String strWeight = weight.getText().toString();
                String strFeet = feet.getText().toString();
                String strInches = inches.getText().toString();

                try {

                    if (strWeight.isEmpty() || strFeet.isEmpty() || strInches.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please enter all values", Toast.LENGTH_SHORT).show();
                    } else {

                        double weight = Double.parseDouble(strWeight);
                        double feet = Double.parseDouble(strFeet);
                        double inches = Double.parseDouble(strInches);

                        double totalInches = (feet * 12) + inches;
                        double m = totalInches * 0.0254;
                        double meterSquare = m * m;

                        double bmi = weight / meterSquare;

                        txtResult.setText("BMI: " + bmi);


                    }


                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}

