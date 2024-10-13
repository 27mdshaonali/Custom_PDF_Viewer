package com.example.audioplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class James extends AppCompatActivity {

    LinearLayout james_1, james_2, james_3, james_4, james_5, james_6, james_7, james_8, james_9, james_10, james_11, james_12;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_james);

        james_1 = findViewById(R.id.james_1);
        james_2 = findViewById(R.id.james_2);
        james_3 = findViewById(R.id.james_3);
        james_4 = findViewById(R.id.james_4);
        james_5 = findViewById(R.id.james_5);
        james_6 = findViewById(R.id.james_6);
        james_7 = findViewById(R.id.james_7);
        james_8 = findViewById(R.id.james_8);
        james_9 = findViewById(R.id.james_9);
        james_10 = findViewById(R.id.james_10);
        james_11 = findViewById(R.id.james_11);
        james_12 = findViewById(R.id.james_12);


        james_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (james_1.getTag() != null && james_1.getTag().toString().contains("Not_Playing")){

                    if (mediaPlayer != null) {

                        mediaPlayer.release();
                        mediaPlayer = MediaPlayer.create(James.this, R.raw.james);
                        mediaPlayer.start();

                    }

                }


            }
        });

        james_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer != null) {

                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(James.this, R.raw.james);
                    mediaPlayer.start();

                }

            }
        });


        james_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer != null) {

                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(James.this, R.raw.james);
                    mediaPlayer.start();

                }

            }
        });


    }
}