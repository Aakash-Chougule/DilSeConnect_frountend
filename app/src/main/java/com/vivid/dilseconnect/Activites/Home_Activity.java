package com.vivid.dilseconnect.Activites;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.vivid.dilseconnect.Fragmets.account_fragment;
import com.vivid.dilseconnect.Fragmets.home_fragement;
import com.vivid.dilseconnect.Fragmets.message_fragment;
import com.vivid.dilseconnect.Fragmets.primum_progile_fragment;
import com.vivid.dilseconnect.R;
import com.vivid.dilseconnect.databinding.ActivityHomeBinding;

public class Home_Activity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replace_fragement(new home_fragement());

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home_menu_item:
                    replace_fragement(new home_fragement());
                    toolbar.setTitle("Home");

                    break;
                case R.id.Primium_profiles_menu_item:
                    replace_fragement(new primum_progile_fragment());
                    toolbar.setTitle("Premium Profiles");
                    break;
                case R.id.Messages_menu_item:
                    replace_fragement(new message_fragment());
                    toolbar.setTitle("Messages");
                    break;
                case R.id.account_menu_item:
                    replace_fragement(new account_fragment());
                    toolbar.setTitle("Account");
                    break;
            }

            return true;
        });
        binding.bottomNavigation.setSelectedItemId(R.id.home_menu_item);
    }

    private void replace_fragement(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameLayout, fragment);
        fragmentTransaction.commit();
    }
}