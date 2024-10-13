package com.example.hashmap;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewsDetails extends AppCompatActivity {


    public static Bitmap BITMAP = null;
    public static String TITLE = "title";
    public static String LONG_DESCRIPTION = "long_description";



    ImageView details_cover_image;

    TextView details_title,details_long_description;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        details_cover_image = findViewById(R.id.cover_image);
        details_title = findViewById(R.id.title);
        details_long_description = findViewById(R.id.long_description);


        details_title.setText(TITLE);
        details_long_description.setText(LONG_DESCRIPTION);

        if (BITMAP != null){
            details_cover_image.setImageBitmap(BITMAP);
        }


    }
}