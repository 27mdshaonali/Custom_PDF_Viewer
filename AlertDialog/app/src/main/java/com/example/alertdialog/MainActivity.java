package com.example.alertdialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button exit;
    LinearLayout allContent;


    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        exit = findViewById(R.id.exit);



        exit.setOnClickListener(v -> {

            LayoutInflater inflater;

            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.dialog, null);

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setView(view);
            alertDialog.show();

            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button yes = view.findViewById(R.id.btnYes);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button no = view.findViewById(R.id.btnNo);


            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(MainActivity.this, "Good Bye!", Toast.LENGTH_SHORT).show();
                    finishAffinity();

                }
            });

            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    alertDialog.dismiss();
                    Toast.makeText(MainActivity.this, "You are not closing the app.Thank You!", Toast.LENGTH_SHORT).show();

                }
            });


        });





    }
}