package com.example.imageload;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView image1, image2;

    Button load_image;

    String image_url_1 = "https://cdn.pixabay.com/photo/2017/06/14/08/20/map-of-the-world-2401458_1280.jpg";
    String image_url_2 = "https://cdn.pixabay.com/photo/2020/11/07/01/28/abstract-5719221_1280.jpg";

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

        image1 = findViewById(R.id.image_1);
        image2 = findViewById(R.id.image_2);

        load_image = findViewById(R.id.load_image);


        Picasso.get().load(image_url_1).placeholder(R.drawable.tech).into(image1);

        load_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Picasso.get().load(image_url_2).placeholder(R.drawable.second_background).into(image2);

            }
        });

    }
}