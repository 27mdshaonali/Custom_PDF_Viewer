package com.example.checkmsginlogcat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView name, phone, mail;
    Button btnLoadInfo;

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

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        mail = findViewById(R.id.mail);

        btnLoadInfo = findViewById(R.id.btnLoadInfo);


        btnLoadInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://appdevman.000webhostapp.com/apps/first%20json%20file.json",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                phone.setText(response);
                                Log.d("serverResponse", response);

                                try {
                                    JSONObject jsonObject = new JSONObject(response);

                                    String nameJ = jsonObject.getString("name");
                                    String phoneJ = jsonObject.getString("phone");
                                    String mailJ = jsonObject.getString("mail");
                                    String addressJ = jsonObject.getString("address");

                                    name.setText(nameJ);
                                    phone.setText(phoneJ);
                                    mail.setText(mailJ);


                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                requestQueue.add(stringRequest);

            }
        });





    }
}