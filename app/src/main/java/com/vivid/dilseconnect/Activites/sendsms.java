package com.vivid.dilseconnect.Activites;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vivid.dilseconnect.R;

public class sendsms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sendsms);
        final EditText phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        final EditText messageEditText = findViewById(R.id.messageEditText);
        Button sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString();
                String message = messageEditText.getText().toString();
                sendSMS(phoneNumber, message);
            }
        });
    }
    private void sendSMS(String phoneNumber, String message) {
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.setData(Uri.parse("smsto:" + phoneNumber));
        smsIntent.putExtra("sms_body", message);

        if (smsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(smsIntent);
        }
    }
}