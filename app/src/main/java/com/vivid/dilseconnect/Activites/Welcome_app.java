package com.vivid.dilseconnect.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vivid.dilseconnect.R;

public class Welcome_app extends AppCompatActivity {

    Button welcome_app_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome_app);
        welcome_app_button = findViewById(R.id.welcome_app_button);
        welcome_app_button.setOnClickListener(v -> {
            Intent intent = new Intent(Welcome_app.this, Home_Activity.class);
            startActivity(intent);
        });

    }
}