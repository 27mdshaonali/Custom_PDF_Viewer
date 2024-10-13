package com.example.multiplesmssendingapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SMS_PERMISSION_CODE = 101;
    private EditText messageInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageInput = findViewById(R.id.messageInput);
        Button sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    sendSmsToCustomers();
                } else {
                    requestPermission();
                }
            }
        });
    }

    private boolean checkPermission() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == SMS_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendSmsToCustomers();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void sendSmsToCustomers() {
        String message = messageInput.getText().toString();
        List<String> customerNumbers = getCustomerNumbers(); // Fetch from your database

        // Send messages in a background thread
        new SmsSenderTask(customerNumbers, message).execute();
    }

    private List<String> getCustomerNumbers() {
        // Replace with actual logic to fetch numbers from your Cloud POS
        return List.of("01796470921", "01571509813"); // Example numbers
    }

    private class SmsSenderTask extends AsyncTask<Void, Void, Void> {
        private final List<String> numbers;
        private final String message;

        SmsSenderTask(List<String> numbers, String message) {
            this.numbers = numbers;
            this.message = message;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            SmsManager smsManager = SmsManager.getDefault();
            for (String number : numbers) {
                smsManager.sendTextMessage(number, null, message, null, null);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(MainActivity.this, "Messages sent", Toast.LENGTH_SHORT).show();
        }
    }
}
