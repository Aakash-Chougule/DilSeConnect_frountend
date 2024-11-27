package com.vivid.dilseconnect.Activites;

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

import com.vivid.dilseconnect.R;

public class Relationship_status extends AppCompatActivity {
Button next_button_relationship_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_relationship_status);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Relationship");
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(R.drawable.noun_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the requested orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        next_button_relationship_status = findViewById(R.id.next_button_relationship_status);
        next_button_relationship_status.setOnClickListener(v -> {
            Intent intent = new Intent(Relationship_status.this, Welcome_app.class);
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