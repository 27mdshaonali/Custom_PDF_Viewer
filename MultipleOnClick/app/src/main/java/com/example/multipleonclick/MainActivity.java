package com.example.multipleonclick;

// Replace with your app package name



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int totalItems = 0;
    private TextView totalItemsTextView;
    private Button buttonItem1;
    private Button buttonItem2;
    private Button buttonItem3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        totalItemsTextView = findViewById(R.id.totalItemsTextView);
        buttonItem1 = findViewById(R.id.btnItem1);
        buttonItem2 = findViewById(R.id.buttonItem2);
        buttonItem3 = findViewById(R.id.buttonItem3);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                // Handle button clicks
                int id = view.getId();
                if (id == R.id.btnItem1 || id == R.id.buttonItem2 || id == R.id.buttonItem3) {
                    totalItems++;
                    updateTotalItemsText();
                }
            }
        };

        buttonItem1.setOnClickListener(onClickListener);
        buttonItem2.setOnClickListener(onClickListener);
        buttonItem3.setOnClickListener(onClickListener);
    }

    @SuppressLint("SetTextI18n")
    private void updateTotalItemsText() {
        totalItemsTextView.setText("Total Items: " + totalItems);
    }
}