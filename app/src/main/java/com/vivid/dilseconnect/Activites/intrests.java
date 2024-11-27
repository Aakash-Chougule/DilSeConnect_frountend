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

import java.util.List;

public class intrests extends AppCompatActivity {

    ChipGroup selectedChipGroup;
    ChipGroup unselectedChipGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intrests);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Intrest");
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(R.drawable.noun_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectedChipGroup = findViewById(R.id.selected_chip_group);
        unselectedChipGroup = findViewById(R.id.unselected_chip_group);

        addChipToUnselected("Travel");
        addChipToUnselected("Music");
        addChipToUnselected("Sports");
        addChipToUnselected("Reading");
        addChipToUnselected("Cooking");
        addChipToUnselected("Photography");

        unselectedChipGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {
            for (Integer checkedId : checkedIds) {
                Chip chip = group.findViewById(checkedId);
                if (chip != null) {// Check if the chip is selected
                    // Move the chip to the selected group
                    unselectedChipGroup.removeView(chip);
                    selectedChipGroup.addView(chip);
                    // Add OnClickListener to thechip after moving it to selectedChipGroup
                    chip.setOnClickListener(v -> {
                        if (!chip.isChecked()) {
                            selectedChipGroup.removeView(chip);
                            unselectedChipGroup.addView(chip);
                        }
                    });
                }
            }
        });
//        selectedChipGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {
//            for (Integer checkedId : checkedIds) {
//                chip = group.findViewById(checkedId);
//
//                if (chip != null) { // Check if the chip is selected
//
//                        selectedChipGroup.removeView(chip);
//                        unselectedChipGroup.addView(chip);
//
//                }
//            }
//        });
    }

    private void addChipToUnselected(String text) {
        Chip chip = new Chip(this);
        chip.setText(text);
        chip.setCheckable(true); // Make chips checkable
        unselectedChipGroup.addView(chip);

    }
    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button press
        finish();
        return true;
    }
}