package com.vivid.dilseconnect.Activites;

import static com.vivid.dilseconnect.Utils.hide_keyboard.hideKeyboard;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.vivid.dilseconnect.Activites.Login_and_info.Get_images_fof_profile;
import com.vivid.dilseconnect.R;
import com.vivid.dilseconnect.Utils.shared_prefrence_util;

import java.util.Calendar;

public class Tell_about_yourself extends AppCompatActivity {

    EditText name_edit_text, email_edit_text, location_edit_text, date_of_birth_edit_text, gender_edit_text;
    Button next_tell_about_yourself_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tell_about_yourself);
        // Set the status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        // Set the toolbar
        Toolbar toolbar = findViewById (R.id.toolbar);
        toolbar.setTitle("About You");
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(R.drawable.noun_back);
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);

        // Set the requested orientation to portrait
//       setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        name_edit_text = findViewById(R.id.name_edit_text);
        email_edit_text = findViewById(R.id.email_edit_text);
        location_edit_text = findViewById(R.id.location_edit_text);
        date_of_birth_edit_text = findViewById(R.id.date_of_birth_edit_text);
        gender_edit_text = findViewById(R.id.gender_edit_text);
        next_tell_about_yourself_button = findViewById(R.id.next_tell_about_yourself_button);

        next_tell_about_yourself_button.setOnClickListener(v -> {
            String name = name_edit_text.getText().toString();
            String email = email_edit_text.getText().toString();
            String location = location_edit_text.getText().toString();
            String date_of_birth = date_of_birth_edit_text.getText().toString();
            String gender = gender_edit_text.getText().toString();
            shared_prefrence_util.initialize(this);

            if (name_edit_text.getText().toString().isEmpty()) {
                hideKeyboard(this, v);
                Snackbar.make(findViewById(android.R.id.content), "Please enter your name", Snackbar.LENGTH_LONG).show();
            } else if (email_edit_text.getText().toString().isEmpty()) {
                hideKeyboard(this, v);
                Snackbar.make(findViewById(android.R.id.content), "Please enter your email", Snackbar.LENGTH_LONG).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email_edit_text.getText().toString()).matches()) {
                hideKeyboard(this, v);
                Snackbar.make(findViewById(android.R.id.content), "Please enter a valid email", Snackbar.LENGTH_LONG).show();
            } else if (location_edit_text.getText().toString().isEmpty()) {
                hideKeyboard(this, v);
                Snackbar.make(findViewById(android.R.id.content), "Please enter your location", Snackbar.LENGTH_LONG).show();
            } else if (date_of_birth_edit_text.getText().toString().isEmpty()) {
                hideKeyboard(this, v);
                Snackbar.make(findViewById(android.R.id.content), "Please enter your date of birth", Snackbar.LENGTH_LONG).show();
            } else if (gender_edit_text.getText().toString().isEmpty()) {
                hideKeyboard(this, v);
                Snackbar.make(findViewById(android.R.id.content), "Please enter your gender", Snackbar.LENGTH_LONG).show();
            }else {
                shared_prefrence_util.putName(name);
                shared_prefrence_util.putEmail(email);
                shared_prefrence_util.putLocation(location);
                shared_prefrence_util.putDateOfBirth(date_of_birth);
                shared_prefrence_util.putGender(gender);
                Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Tell_about_yourself.this, Get_images_fof_profile.class);
                startActivity(intent);
            }
        });
        date_of_birth_edit_text.setOnClickListener(v -> openDialog());
    }

    private void openDialog() {
        // Get the current date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a new DatePickerDialog
        DatePickerDialog dtdialog = new DatePickerDialog(this, (datePicker, year1, month1, dayOfMonth1) -> {
            // Format the date as a string
            String date = dayOfMonth1 + "/" + (month1 + 1) + "/" + year1;

            // Set the selected date in the EditText
            date_of_birth_edit_text.setText(date);
        }, year, month, dayOfMonth);
        dtdialog.getDatePicker().setMaxDate(System.currentTimeMillis());

        // Show the DatePickerDialog
        dtdialog.show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button press
        finish();
        return true;
    }
}