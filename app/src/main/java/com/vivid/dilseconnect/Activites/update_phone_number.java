package com.vivid.dilseconnect.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vivid.dilseconnect.R;

public class update_phone_number extends AppCompatActivity {
LinearLayout phone_number_update_settings_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_phone_number);

        phone_number_update_settings_layout = findViewById(R.id.update_my_phone_number_btn);
        phone_number_update_settings_layout.setOnClickListener(v -> {
            // Handle the click event here
            Intent intent = new Intent(this, phone_number.class);
            startActivity(intent);
        });
    }
}