package com.vivid.dilseconnect.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vivid.dilseconnect.R;

public class phone_number extends AppCompatActivity {
    Button Send_OTP_phone_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_phone_number);

        Send_OTP_phone_update = findViewById(R.id.Send_OTP_phone_update);
        Send_OTP_phone_update.setOnClickListener(v -> {
            // Handle the click event here
            Intent intent = new Intent(this, update_phone_otp.class);
            startActivity(intent);
        });
    }
}