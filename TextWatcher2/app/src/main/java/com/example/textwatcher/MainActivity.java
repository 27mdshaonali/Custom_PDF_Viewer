package com.example.textwatcher;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name, phone;

    Button save, next;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

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


        phone = findViewById(R.id.phone);
        name = findViewById(R.id.name);
        save = findViewById(R.id.save);
        next = findViewById(R.id.next);


        sharedPreferences = getSharedPreferences("Shaon", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        //we can also add here the textWatcher
        save.setEnabled(false); //like this we can disable the button


        name.addTextChangedListener(textWatcher);


    }

    public TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {



        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String myName = name.getText().toString().trim();
            String myPhone = phone.getText().toString().trim();

            if (!myName.isEmpty()){
                save.setEnabled(true);
            } else {
                save.setEnabled(false);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}