package com.example.multipleonclicklistener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        button1 = findViewById(R.id.first_activity_button);
        button2 = findViewById(R.id.second_activity_button);
        button3 = findViewById(R.id.third_activity_button);
        button4 = findViewById(R.id.fourth_activity_button);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.first_activity_button){

            startActivity(new Intent(MainActivity.this, FirstActivity.class));

        } else if (v.getId() == R.id.second_activity_button) {

            startActivity(new Intent(MainActivity.this, SecondActivity.class));

        } else if (v.getId() == R.id.third_activity_button) {

            startActivity(new Intent(MainActivity.this, ThirdActivity.class));

        } else if (v.getId() == R.id.fourth_activity_button) {

            startActivity(new Intent(MainActivity.this, FourthActivity.class));

        }

    }
}