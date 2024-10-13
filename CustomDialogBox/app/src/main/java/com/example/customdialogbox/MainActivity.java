package com.example.customdialogbox;

import static com.example.customdialogbox.R.layout.*;

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


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button = findViewById(R.id.showDialog);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater;
                layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                @SuppressLint("InflateParams") View view = layoutInflater.inflate(dialog, null);

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setView(view);

                Button buttonYes = view.findViewById(R.id.yes);
                Button buttonNo = view.findViewById(R.id.no);
                alertDialog.show();

                buttonYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        finishAffinity();

                    }
                });

                buttonNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        alertDialog.dismiss();
                        Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }

    @SuppressLint("MissingSuperCall")
    public void onBackPressed() {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View view = layoutInflater.inflate(dialog, null);

        AlertDialog builder = new AlertDialog.Builder(MainActivity.this).create();
        builder.setView(view);




        Button buttonYes = view.findViewById(R.id.yes);
        Button buttonNo = view.findViewById(R.id.no);

        builder.show();

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();

            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.dismiss();
                Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();

            }
        });



    }

}