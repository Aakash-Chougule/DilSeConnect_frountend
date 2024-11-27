package com.vivid.dilseconnect.Activites.Login_and_info;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.vivid.dilseconnect.Activites.Tell_about_yourself;
import com.vivid.dilseconnect.Utils.OTPUtils;
import com.vivid.dilseconnect.R;
import com.vivid.dilseconnect.Utils.hide_keyboard;
import com.vivid.dilseconnect.Utils.shared_prefrence_util;

public class Get_otp extends AppCompatActivity {
    TextView timerTextView;
    EditText Otp_edit_text;
    Button Confirm_button, resend_otp_button;
    CountDownTimer countDownTimer;
    TextView phone_number_text;
    String otp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_otp);

        // Set the status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        Toolbar toolbar = findViewById (R.id.toolbar);
        toolbar.setTitle("OTP Verification");
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(R.drawable.noun_back);
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);

        // Set the requested orientation to portrait
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        timerTextView = findViewById(R.id.timerTextView);
        Otp_edit_text = findViewById(R.id.opt_edit_text);
        Confirm_button = findViewById(R.id.confirm_otp_button);
        phone_number_text = findViewById(R.id.phone_number_text_view);
        resend_otp_button = findViewById(R.id.resend_otp_button);
        shared_prefrence_util.initialize(this);


        // Get the OTP from the intent
        otp = getIntent().getStringExtra("otp");

        Snackbar.make(findViewById(android.R.id.content), otp, Snackbar.LENGTH_LONG).show();
       // String phone_number = getIntent().getStringExtra("phone_number");
        // Display the phone number
        String phone_number = shared_prefrence_util.getMobileNo("");
        phone_number_text.setText(phone_number);

        // Start the countdown timer
        startCountdownTimer();

        // Set the resend button click listener
        resend_otp_button.setOnClickListener(v -> {
            timerTextView.setVisibility(View.VISIBLE);
            resend_otp_button.setVisibility(View.GONE);;
            startCountdownTimer();
            String otp1 = OTPUtils.generateOTP(6);
            Snackbar.make(findViewById(android.R.id.content), otp1, Snackbar.LENGTH_LONG).show();
            otp = otp1;
        });



        Confirm_button.setOnClickListener(v -> {
            if (Otp_edit_text.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter your OTP", Toast.LENGTH_SHORT).show();
                hide_keyboard.hideKeyboard(this,v);
            } else if (Otp_edit_text.getText().toString().length() != 6) {
                hide_keyboard.hideKeyboard(this,v);
                Toast.makeText(this, "Invalid OTP", Toast.LENGTH_SHORT).show();
            } else if (Otp_edit_text.getText().toString().equals(otp)) {
                hide_keyboard.hideKeyboard(this,v);
                Toast.makeText(this, "OTP verified", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Get_otp.this, Tell_about_yourself.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid OTP", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void startCountdownTimer() {
        countDownTimer = new CountDownTimer(60000, 1000) { // 1 minute, tick every second
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsRemaining = millisUntilFinished / 1000;
                timerTextView.setText(String.format("00:%02d", secondsRemaining));
            }

            // OTP expiration
            @Override
            public void onFinish() {
                timerTextView.setText("00:00");
                // Handle OTP expiration (e.g., disable confirm button)
                timerTextView.setVisibility(View.GONE);
                resend_otp_button.setVisibility(View.VISIBLE);
//                Confirm_button.setEnabled(false);
            }
        }.start();
    }
    // Stop the countdown timer when the activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button press
        finish();
        return true;
    }

}