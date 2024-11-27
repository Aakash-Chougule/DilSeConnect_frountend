package com.vivid.dilseconnect.Activites.Login_and_info;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vivid.dilseconnect.R;

public class LoginPage extends AppCompatActivity {

    VideoView videoView;
    Button login_via_phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

//        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        // Set the requested orientation to portrait
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Initialize the VideoView
        videoView = findViewById(R.id.video_view);
        // Set the video file to play
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bg_video);
        videoView.setVideoURI(uri);
        videoView.start();

        // Set the videoView to loop
        videoView.setOnPreparedListener(mp -> mp.setLooping(true));

        login_via_phone_number = findViewById(R.id.login_via_phone_number);
        login_via_phone_number.setOnClickListener(v -> {
            Intent intent = new Intent(LoginPage.this, Login_via_phone_no.class);
            startActivity(intent);
            finish();
        });

    }

    // Start the video when the activity is resumed
    @Override
    protected void onResume() {
        videoView.resume();
        super.onPostResume();
    }

    // Stop the video when the activity is paused
    @Override
    protected void onRestart() {
        videoView.start();
        super.onRestart();
    }

    // Stop the video when the activity is paused
    @Override
    protected void onPause() {
        videoView.suspend();
        super.onPause();
    }

    // Stop the video when the activity is destroyed
    @Override
    protected void onDestroy() {
        videoView.stopPlayback();
        super.onDestroy();
    }

    // Handle the back button press
    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button press
        finish();
        return true;
    }
}