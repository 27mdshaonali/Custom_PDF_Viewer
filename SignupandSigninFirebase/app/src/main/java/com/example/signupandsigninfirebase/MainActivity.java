package com.example.signupandsigninfirebase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email, password;
    ProgressBar loginProgressBar;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView signUp = findViewById(R.id.signup);
        loginProgressBar = findViewById(R.id.loginProgressBar);



        signUp.setOnClickListener(this);
        btnLogin.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnLogin){

            userLogin();

        } else if (v.getId() == R.id.signup){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity2.class));
        }


    }

    private void userLogin() {

        String sEmail = email.getText().toString().trim();
        String sPassword = password.getText().toString().trim();

        if (sEmail.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()){

            email.setError("Please enter a valid email");
            email.requestFocus();
            return;

        }

        if (sPassword.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        if (password.length() < 6){
            password.setError("Minimum length of password should be 6");
            password.requestFocus();
            return;
        }

        loginProgressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                loginProgressBar.setVisibility(View.GONE);

                if (task.isSuccessful()){
                    finish();
                    Toast.makeText(getApplicationContext(), "Login is successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login is not successful", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }






}