package com.vivid.dilseconnect.Activites;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vivid.dilseconnect.R;
import com.vivid.dilseconnect.Utils.shared_prefrence_util;

public class profiles_preview extends AppCompatActivity{

    TextView profile_name_profile_preview, profile_age_profile_preview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profiles_preview);
        // Set the status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Profile");
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(R.drawable.noun_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the requested orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        profile_name_profile_preview = findViewById(R.id.profile_name_profile_preview);

        ImageView imageView = findViewById(R.id.img1); // Find your ImageView
        TextView nameTextView = findViewById(R.id.profile_name_profile_preview); // Find your TextView

        int imageResId = getIntent().getIntExtra("imageResId", 0); // Get image resource ID
        String imageName = getIntent().getStringExtra("imageName"); // Get image name

        if (imageResId != 0) {
            imageView.setImageResource(imageResId);
        }

        if (imageName!= null) {
            nameTextView.setText(imageName);
        }


    }
    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button press
        finish();
        return true;
    }
}