package com.example.multiplicationtable;

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

    EditText multiplicationTableNumber, multiplicationEndNumber;
    Button clearButton, generateButton;
    TextView multiplicationTableText;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        multiplicationTableNumber = findViewById(R.id.multiplicationTableNumber);
        multiplicationEndNumber = findViewById(R.id.multiplicationEndNumber);
        clearButton = findViewById(R.id.clearButton);
        generateButton = findViewById(R.id.generateButton);
        multiplicationTableText = findViewById(R.id.multiplicationTableText);


        try {

            clearButton.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {

                    multiplicationTableNumber.setText("");
                    multiplicationTableNumber.setHint("Enter a number");

                    multiplicationEndNumber.setText("");
                    multiplicationEndNumber.setHint("Enter end number");

                    multiplicationTableText.setText("Multiplication Table: ");

                }
            });


            generateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String stringStartNumber = multiplicationTableNumber.getText().toString().trim();
                    String stringEndNumber = multiplicationEndNumber.getText().toString().trim();

                    if (stringStartNumber.isEmpty() || stringEndNumber.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    int intEndNumber = Integer.parseInt(stringEndNumber);

                    multiplicationTableText.setText("Multiplication Table: " + "\n\n");

                    for (int i = 1; i <= intEndNumber; i++) {

                        int intStartNumber = Integer.parseInt(stringStartNumber);

                        multiplicationTableText.append(intStartNumber + " X " + i + " = " + intStartNumber * i + "\n");

                    }


                }
            });


        } catch (Exception e) {

            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();

        }


    }
}