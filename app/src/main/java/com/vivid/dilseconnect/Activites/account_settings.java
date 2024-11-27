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

import com.vivid.dilseconnect.MainActivity;
import com.vivid.dilseconnect.R;

public class account_settings extends AppCompatActivity {

    LinearLayout deactivate_account_settings_layout, delete_account_settings_layout, logout_account_settings_layout;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account_settings);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Account Settings");
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(R.drawable.noun_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        deactivate_account_settings_layout = findViewById(R.id.deactivate_account_account_setting);
        delete_account_settings_layout = findViewById(R.id.delete_account_account_setting);
        logout_account_settings_layout = findViewById(R.id.logout_account_setting);

        deactivate_account_settings_layout.setOnClickListener(v -> {
            intent = new Intent(this, deactivate_account.class);
            startActivity(intent);
        });
        delete_account_settings_layout.setOnClickListener(v -> {
            intent = new Intent(this, delete_account.class);
            startActivity(intent);
        });
        logout_account_settings_layout.setOnClickListener(v -> {
            intent = new Intent(this, logout_account.class);
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