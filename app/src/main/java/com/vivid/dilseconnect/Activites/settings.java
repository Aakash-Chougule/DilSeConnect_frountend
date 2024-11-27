package com.vivid.dilseconnect.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vivid.dilseconnect.R;

public class settings extends AppCompatActivity {
    LinearLayout phone_number_update_settings_layout,privacy_settings_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Settings");
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(R.drawable.noun_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        phone_number_update_settings_layout = findViewById(R.id.phone_number_update_settings_layout);
        privacy_settings_layout = findViewById(R.id.privacy_update_settings_layout);

        phone_number_update_settings_layout.setOnClickListener(v -> {
            // Handle the click event here
            Intent intent = new Intent(this, update_phone_number.class);
            startActivity(intent);
        });
        privacy_settings_layout.setOnClickListener(v -> {
            // Handle the click event here
            Intent intent = new Intent(this, privacy_settings.class);
            startActivity(intent);
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button press
        finish();
        return true;
    }
}