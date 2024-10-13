package com.example.customalertdialog;

import static android.os.Build.VERSION_CODES.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

    Button btn_show_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        btn_show_dialog = findViewById(R.id.btn_show_dialog);

        btn_show_dialog.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("InflateParams")
            @Override
            public void onClick(View v) {

                LayoutInflater inflater;
                inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View view = inflater.inflate(R.layout.dialog_box, null);

                @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnYes = view.findViewById(R.id.btnYes);
                @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnNo = view.findViewById(R.id.btnNo);

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setView(view);
                alertDialog.show();

                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        finishAffinity();

                    }
                });


                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        alertDialog.dismiss();
                        startActivity(new Intent(MainActivity.this, AnotherActivity.class));

                        Toast.makeText(MainActivity.this, "No button has clicked!", Toast.LENGTH_SHORT).show();

                        // press Ctrl+Alt+Shift+L to format the code

                    }
                });

            }
        });


    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

        LayoutInflater inflater;
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.dialog_box, null);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnYes = view.findViewById(R.id.btnYes);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnNo = view.findViewById(R.id.btnNo);

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setView(view);
        alertDialog.show();

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finishAffinity();

            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.dismiss();
                startActivity(new Intent(MainActivity.this, AnotherActivity.class));

                Toast.makeText(MainActivity.this, "No button has clicked!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}