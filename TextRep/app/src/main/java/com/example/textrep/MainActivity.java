package com.example.textrep;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edText,edRepeatTime;
    Button btnSubmit;
    TextView result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.edText);
        edRepeatTime = findViewById(R.id.edRepeatTime);
        btnSubmit = findViewById(R.id.btnSubmit);
        result = findViewById(R.id.result);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = edText.getText().toString();

                String repeatTime = edRepeatTime.getText().toString();
                int time = Integer.parseInt(repeatTime);



                for (int num = 1; num <= time; num++) {

                    result.append("\n"+text+"");

                }

            }
        });

    }
}