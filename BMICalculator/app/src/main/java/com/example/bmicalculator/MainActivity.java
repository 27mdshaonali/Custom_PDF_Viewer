package com.example.bmicalculator;

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
    Button calculateBMI;
    TextView result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        weight = findViewById(R.id.weight);
        feet = findViewById(R.id.feet);
        inches = findViewById(R.id.inches);
        calculateBMI = findViewById(R.id.calculateBMI);
        result = findViewById(R.id.result);


        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String weightValue = weight.getText().toString();
                String feetValue = feet.getText().toString();
                String inchesValue = inches.getText().toString();

                try {

                    if (weightValue.isEmpty() || feetValue.isEmpty() || inchesValue.isEmpty()) {

                        result.setText("Result: ");
                        Toast.makeText(MainActivity.this, "Please enter all values", Toast.LENGTH_SHORT).show();

                    } else {

                        float fWeightValue = Float.parseFloat(weightValue);
                        float fFeetValue = Float.parseFloat(feetValue);
                        float fInchesValue = Float.parseFloat(inchesValue);

                        float totalInches = (fFeetValue * 12) + fInchesValue; // we are converting feet to inches and adding it to the inches value
                        float meter = totalInches * 0.0254f; // converting inches to meters by multiplying it with 0.0254

                        float meterSquare = meter * meter; // calculating the square of the meter
                        float BMI = fWeightValue / meterSquare; // calculating the BMI

                        if (BMI < 18.5) {
                            result.setText("Your BMI Score is: " + BMI + " and you are underweight");
                        } else if (BMI >= 18.5 && BMI <= 24.9) {

                            result.setText("Your BMI Score is: " + BMI + " and you are normal");

                        } else if (BMI >= 25 && BMI <= 29.9) {

                            result.setText("Your BMI Score is: " + BMI + " and you are overweight");

                        } else {

                            result.setText("Your BMI Score is: " + BMI + " and you are obese");

                        }

                    }


                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}