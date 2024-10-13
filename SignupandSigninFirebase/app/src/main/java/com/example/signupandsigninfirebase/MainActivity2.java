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

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    EditText sSignUpMail, sSignUpPassword;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    Button btnSignUp;
    TextView login;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        sSignUpMail = findViewById(R.id.signUpEmail);
        sSignUpPassword = findViewById(R.id.signUpPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        login = findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);


        login.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {



        if (v.getId() == R.id.btnSignUp){

            userRegister();

        } else if(v.getId() == R.id.login){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }





    }

    private void userRegister() {

        String email = sSignUpMail.getText().toString().trim();
        String password = sSignUpPassword.getText().toString().trim();

        if (email.isEmpty()){
            sSignUpMail.setError("Email is required");
            sSignUpMail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            sSignUpMail.setError("Please enter a valid email");
            sSignUpMail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            sSignUpPassword.setError("Password is required");
            sSignUpPassword.requestFocus();
            return;
        }

        if (sSignUpPassword.length() < 6){
            sSignUpPassword.setError("Minimum length of password should be 6");
            sSignUpPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);

                if (task.isSuccessful()){

                    finish();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    Toast.makeText(getApplicationContext(), "Register is successful", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), "Register is not successful", Toast.LENGTH_SHORT).show();

                }

            }
        });



    }
}