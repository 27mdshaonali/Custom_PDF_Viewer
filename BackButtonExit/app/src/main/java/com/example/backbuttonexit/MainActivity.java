package com.example.backbuttonexit;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);






    }


    @Override
    public void onBackPressed() {

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.layout, null);

        View view = inflater.inflate(R.layout.layout, null);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button no = view.findViewById(R.id.btnNo);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button yes = view.findViewById(R.id.btnYes);


        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setView(view);
        alertDialog.show();

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.dismiss();
                Toast.makeText(MainActivity.this, "No button has clicked", Toast.LENGTH_SHORT).show();

            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finishAffinity();

            }
        });

    }
}