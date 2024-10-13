package com.example.digitaltasbi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView cover;

    TextView bismillah;
    String cover_url = "https://i.pinimg.com/736x/68/f0/89/68f0899f28c7c624005fc4cd4ac51cb8.jpg";

    TextView alhamdulillah,alhamdulillah_count,subahan_allah,subahan_allah_count,laa_ilaha_illallah,laa_ilaha_illallah_count;
    RelativeLayout coverImage;
    Button btn;

    int count = 0;

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
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



        bismillah = findViewById(R.id.bismillah);

        cover = findViewById(R.id.cover);

        alhamdulillah = findViewById(R.id.alhamdulillah);
        alhamdulillah_count = findViewById(R.id.alhamdulillah_count);
        subahan_allah = findViewById(R.id.subahan_allah);
        subahan_allah_count = findViewById(R.id.subahan_allah_count);
        laa_ilaha_illallah = findViewById(R.id.laa_ilaha_illallah);
        laa_ilaha_illallah_count = findViewById(R.id.laa_ilaha_illallah_count);
        coverImage = findViewById(R.id.coverImage);
        btn = findViewById(R.id.btn);


        Picasso.get().load(cover_url)
                .placeholder(R.drawable.tech)
                .into(cover);

        btn.setEnabled(false);


        subahan_allah.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {



                btn.setEnabled(true);

                btn.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View v) {

                        count = count + 1;
                        subahan_allah_count.setText(""+count);

                    }
                });


                return true;
            }
        });


    }
}