package com.example.alertdia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {

            LayoutInflater layoutInflater;

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            @SuppressLint("InflateParams") View view = layoutInflater.inflate(R.layout.layout, null);

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setView(view);
            alertDialog.show();

            Button yes = view.findViewById(R.id.btnYes);
            Button no = view.findViewById(R.id.btnNo);

            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    finishAffinity();

                }
            });

            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    alertDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Button No has Clicked", Toast.LENGTH_SHORT).show();

                }
            });

            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();

        });


    }
}