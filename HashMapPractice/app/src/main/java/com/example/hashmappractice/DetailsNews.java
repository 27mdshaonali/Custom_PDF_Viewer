package com.example.hashmappractice;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.codesgood.views.JustifiedTextView;

public class DetailsNews extends AppCompatActivity {

    ImageView cover_image;
    TextView cover_title;
    TextView details_news_description;

    public static String TITLE = "";
    public static String DESCRIPTION = "";
    public static Bitmap IMAGE = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details_news);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cover_image = findViewById(R.id.cover_image);
        cover_title = findViewById(R.id.cover_title);
        details_news_description = findViewById(R.id.details_news_description);

        cover_title.setText(TITLE);
        details_news_description.setText(DESCRIPTION);
        if (IMAGE != null){
            cover_image.setImageBitmap(IMAGE);
        }

    }
}