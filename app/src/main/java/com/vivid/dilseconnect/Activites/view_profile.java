package com.vivid.dilseconnect.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.vivid.dilseconnect.R;

public class view_profile extends AppCompatActivity {
    TextView basic_info_view_profile, edit_image1_view_profile, edit_image2_view_profile, edit_image3_view_profile;
    TextView edit_image4_view_profile, edit_basic_chipset_view_profile, edit_Mantra_chipset_view_profile,edit_my_story_chipset_view_profile;
    TextView edit_intrest_chipset_view_profile,edit_qualities_chipset_view_profile,edit_philosophy_chipset_view_profile,edit_relationship_goal_chipset_view_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_profile);

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

        basic_info_view_profile = findViewById(R.id.edit_basic_info_view_profile);
        edit_image1_view_profile = findViewById(R.id.edit_image1_view_profile);
        edit_image2_view_profile = findViewById(R.id.edit_image2_view_profile);
        edit_image3_view_profile = findViewById(R.id.edit_image3_view_profile);
        edit_image4_view_profile = findViewById(R.id.edit_image4_view_profile);
        edit_basic_chipset_view_profile = findViewById(R.id.edit_basic_chipset_view_profile);
        edit_Mantra_chipset_view_profile = findViewById(R.id.edit_Mantra_chipset_view_profile);
        edit_my_story_chipset_view_profile = findViewById(R.id.edit_my_story_chipset_view_profile);
        edit_intrest_chipset_view_profile = findViewById(R.id.edit_intrest_chipset_view_profile);
        edit_qualities_chipset_view_profile = findViewById(R.id.edit_qualities_chipset_view_profile);
        edit_philosophy_chipset_view_profile = findViewById(R.id.edit_philosophy_chipset_view_profile);
        edit_relationship_goal_chipset_view_profile = findViewById(R.id.edit_relationship_goal_chipset_view_profile);


        basic_info_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, basic_info.class);
            startActivity(intent);
        });
        edit_image1_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, edit_images_account.class);
            startActivity(intent);
        });
        edit_image2_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, edit_images_account.class);
            startActivity(intent);
        });
        edit_image3_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, edit_images_account.class);
            startActivity(intent);
        });
        edit_image4_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, edit_images_account.class);
            startActivity(intent);
        });
        edit_basic_chipset_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, basic_info_chips.class);
            startActivity(intent);
        });
        edit_Mantra_chipset_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, mantra_chips.class);
            startActivity(intent);
        });
        edit_my_story_chipset_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, my_story_chips.class);
            startActivity(intent);
        });
        edit_intrest_chipset_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, intrests.class);
            startActivity(intent);
        });
        edit_qualities_chipset_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, qualities.class);
            startActivity(intent);
        });
        edit_philosophy_chipset_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, philosophy.class);
            startActivity(intent);
        });
        edit_relationship_goal_chipset_view_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, relationship_goal.class);
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