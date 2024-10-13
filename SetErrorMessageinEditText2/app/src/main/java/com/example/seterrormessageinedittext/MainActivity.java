package com.example.seterrormessageinedittext;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText name,phone_number,email_address;
    Button next_button;


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


        name = findViewById(R.id.name);
        phone_number = findViewById(R.id.phone_number);
        email_address = findViewById(R.id.email_address);
        next_button = findViewById(R.id.next_button);



        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String sName = name.getText().toString().trim();
                String sPhone_number = phone_number.getText().toString().trim();
                String sEmail_address = email_address.getText().toString().trim();

                if (sName.length()==0 ){
                    name.setError("Please enter your name");
                } else if (sPhone_number.length()==0 ){
                    phone_number.setError("Please enter your phone number");
                } else {

                    startActivity(new Intent(MainActivity.this, NextActivity.class));

                }


            }
        });




    }
}