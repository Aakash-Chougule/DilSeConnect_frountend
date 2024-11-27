package com.vivid.dilseconnect.Activites.Login_and_info;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.vivid.dilseconnect.Utils.OTPUtils;
import com.vivid.dilseconnect.R;
import com.vivid.dilseconnect.Utils.shared_prefrence_util;

public class Login_via_phone_no extends AppCompatActivity {

    Button send_otp_button;
    EditText phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_via_phone_no);
        // Set the status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Phone Login");
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(R.drawable.noun_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        // Set the requested orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        send_otp_button = findViewById(R.id.Send_OTP_button);
        phone_number = findViewById(R.id.phone_number_edit_text);
        shared_prefrence_util.initialize(this);


        send_otp_button.setOnClickListener(v -> {
            String phone = phone_number.getText().toString();
            if (phone.isEmpty()) {
                Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
            } else if (phone.length() >= 10) {
                String otp = OTPUtils.generateOTP(6);
                Toast.makeText(this, "OTP sent successfully" + phone_number.getText().toString(), Toast.LENGTH_SHORT).show();
                // Navigate to the main activity
                Intent intent = new Intent(Login_via_phone_no.this, Get_otp.class);
                intent.putExtra("otp", otp);
                shared_prefrence_util.putMobileNo(phone);
//                intent.putExtra("phone_number", phone_number.getText().toString());
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Generate a random OTP of a specified length
//    private String generateOTP(int length) {
//        Random random = new Random();
//        StringBuilder otp = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            otp.append(random.nextInt(10)); // Generate random digits from 0 to 9
//        }
//        return otp.toString();
//    }
    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button press
        finish();
        return true;
    }
}