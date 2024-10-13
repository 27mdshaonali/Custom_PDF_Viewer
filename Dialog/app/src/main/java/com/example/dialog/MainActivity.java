package com.example.dialog;

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

    LayoutInflater layoutInflater;
    Button showDialog;

    AlertDialog alertDialog;



    @SuppressLint("MissingInflatedId")
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


        showDialog = findViewById(R.id.button);













        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                @SuppressLint("InflateParams") View view = layoutInflater.inflate(R.layout.dialog, null, false);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(view);

                Button yes = view.findViewById(R.id.yes);
                Button no = view.findViewById(R.id.no);

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        finishAndRemoveTask();

                        Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();

                    }
                });


                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();

                    }
                });




                alertDialog = builder.create();
                alertDialog.show();







            }
        });





    }








    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        @SuppressLint("InflateParams") View view = layoutInflater.inflate(R.layout.dialog, null, false);


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(view);

        Button yes = view.findViewById(R.id.yes);
        Button no = view.findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finishAndRemoveTask();

                Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();

            }
        });


        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();

            }
        });


        alertDialog = builder.create();
        alertDialog.show();


    }
}