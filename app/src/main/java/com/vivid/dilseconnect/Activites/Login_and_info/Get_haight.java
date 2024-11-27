package com.vivid.dilseconnect.Activites.Login_and_info;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.vivid.dilseconnect.Activites.Religion;
import com.vivid.dilseconnect.R;

public class Get_haight extends AppCompatActivity {

    Button next_button_height_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_haight);
        // Set the status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Height");
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(R.drawable.noun_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the requested orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        next_button_height_layout = findViewById(R.id.next_button_height_layout);
        next_button_height_layout.setOnClickListener(v -> {
            Intent intent = new Intent(Get_haight.this, Religion.class);
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