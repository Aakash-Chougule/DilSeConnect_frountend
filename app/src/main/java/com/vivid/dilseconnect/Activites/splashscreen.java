package com.vivid.dilseconnect.Activites;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vivid.dilseconnect.Activites.Login_and_info.LoginPage;
import com.vivid.dilseconnect.Fragmets.home_fragement;
import com.vivid.dilseconnect.R;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashscreen);
        //setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Thread thread = new Thread(){
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(splashscreen.this, LoginPage.class));
                    finish();
                }
            }
        };
        thread.start();

    }

}