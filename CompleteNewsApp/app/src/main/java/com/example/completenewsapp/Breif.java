package com.example.completenewsapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Breif extends AppCompatActivity {

    ImageView coverImg;

    TextView title,description;

    public static String TITLE = "title";
    public static String DESCRIPTION = "description";
    public static Bitmap COVER_IMG = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_breif);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        coverImg = findViewById(R.id.coverImg);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);


        title.setText(TITLE);
        description.setText(DESCRIPTION);

        if (coverImg != null){
            coverImg.setImageBitmap(COVER_IMG);
        }



    }
}