package com.vivid.dilseconnect.Activites;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.vivid.dilseconnect.R;

public class qualities extends AppCompatActivity {
    ChipGroup selectedChipGroup_qualities;
    ChipGroup unselectedChipGroup_qualities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qualities);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Qualities");
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(R.drawable.noun_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectedChipGroup_qualities = findViewById(R.id.selected_chip_group_qualities);
        unselectedChipGroup_qualities = findViewById(R.id.unselected_chip_group_qualities);
        addChipToUnselected("Good");
        addChipToUnselected("Bad");
        addChipToUnselected("Neutral");

        unselectedChipGroup_qualities.setOnCheckedStateChangeListener((group, checkedIds) -> {
            for (Integer checkedId : checkedIds) {
                Chip chip = group.findViewById(checkedId);
                if (chip != null) {
                    // Move the chip to the selected group
                    unselectedChipGroup_qualities.removeView(chip);
                    selectedChipGroup_qualities.addView(chip);
                    chip.setOnClickListener(v -> {
                        if (!chip.isChecked()) {
                            selectedChipGroup_qualities.removeView(chip);
                            unselectedChipGroup_qualities.addView(chip);
                        }
                    });
                }
            }
        });


    }
    private void addChipToUnselected(String text) {
        Chip chip = new Chip(this);
        chip.setText(text);
        chip.setCheckable(true); // Make chips checkable
        unselectedChipGroup_qualities.addView(chip);
    }
    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button press
        finish();
        return true;
    }
}
