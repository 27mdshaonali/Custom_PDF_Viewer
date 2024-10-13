package com.example.multip;

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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText firstNumber, lastNumber,number,endNumber;
        Button clearTxt,makeTable;
        TextView result;

        firstNumber = findViewById(R.id.firstNumber);
        lastNumber = findViewById(R.id.lastNumber);
        number = findViewById(R.id.number);
        endNumber = findViewById(R.id.endNumber);
        clearTxt = findViewById(R.id.clearTxt);
        makeTable = findViewById(R.id.makeTable);
        result = findViewById(R.id.result);

        clearTxt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                number.setText("");
                number.setHint("Enter a Number");

                endNumber.setText("");
                endNumber.setHint("Enter a Number");

                result.setText("Result: ");

            }
        });

        makeTable.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String first = firstNumber.getText().toString();
                String last = lastNumber.getText().toString();
                String num = number.getText().toString();
                String end = endNumber.getText().toString();


                try {

                    int f = Integer.parseInt(first);
                    int l = Integer.parseInt(last);
                    int n = Integer.parseInt(num);
                    int e = Integer.parseInt(end);

                    result.setText("Multiplication Table of " + n + " : \n\n");

                    for (int i = f; i <= l; i++) {
                        result.append(n + " x " + i + " = " + n * i +" ");
                    }

                    for (int i = 1; i <= e; i++) {

                        result.append(n + " x " + i + " = " + n * i +"\n");

                    }

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Enter a Valid Number", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}