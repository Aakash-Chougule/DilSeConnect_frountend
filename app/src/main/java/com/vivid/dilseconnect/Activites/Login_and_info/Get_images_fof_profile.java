package com.vivid.dilseconnect.Activites.Login_and_info;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.Manifest;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.vivid.dilseconnect.R;

public class Get_images_fof_profile extends AppCompatActivity {

    ImageView firstimage, secondimage, thirdimage, fourthimage;
    Button save_button;
    // Image pick code
    private static final int IMAGE_PICK_CODE = 1000;
    // Permission code
    private static final int PERMISSION_CODE = 1001;
    int flag = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_images_fof_profile);

        // Set the status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_primary_color));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Profile Images");
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(R.drawable.noun_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the requested orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        firstimage = findViewById(R.id.firstImage);
        secondimage = findViewById(R.id.second_image);
        thirdimage = findViewById(R.id.thirdImage);
        fourthimage = findViewById(R.id.fourthImage);
        save_button = findViewById(R.id.save_button);

        firstimage.setOnClickListener(v -> {
            flag = 1;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                    requestPermissions(permissions, PERMISSION_CODE);
                }
//                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE
//                        == PackageManager.PERMISSION_DENIED)){
//                    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
//                    requestPermissions(permissions, PERMISSION_CODE);
//                }
                else {
                    pickImageFromGallery();
                }
            }else {
                pickImageFromGallery();
            }
        });
        secondimage.setOnClickListener(v ->{
            flag = 2;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){ // Android 6.0 Marshmallow
                // check permission
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                    requestPermissions(permissions, PERMISSION_CODE);// request permission
                }
//                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE
//                        == PackageManager.PERMISSION_DENIED)){
//                    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
//                    requestPermissions(permissions, PERMISSION_CODE);
//                }
                else {
                    pickImageFromGallery();
                }
            }else {
                pickImageFromGallery();
            }
        });
        thirdimage.setOnClickListener(v->{
            flag = 3;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){ // Android 6.0 Marshmallow
                // check permission
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                    requestPermissions(permissions, PERMISSION_CODE);// request permission
                }
//                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE
//                        == PackageManager.PERMISSION_DENIED)){
//                    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
//                    requestPermissions(permissions, PERMISSION_CODE);
//                }
                else {
                    pickImageFromGallery();
                }
            }else {
                pickImageFromGallery();
            }
        });
        fourthimage.setOnClickListener(v->{
            flag = 4;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){ // Android 6.0 Marshmallow
                // check permission
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                    requestPermissions(permissions, PERMISSION_CODE);// request permission
                }
                else {
                    pickImageFromGallery();
                }
            }else {
                pickImageFromGallery();
            }
        });
        save_button.setOnClickListener(v -> {
            Intent intent = new Intent(Get_images_fof_profile.this, Get_haight.class);
            startActivity(intent);
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
        });
    }
    // Function to pick image from gallery
    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery();
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            if (flag == 1) {
                firstimage.setImageURI(data.getData());
            }
            if (flag == 2) {
                secondimage.setImageURI(data.getData());
            }
            if (flag == 3) {
                thirdimage.setImageURI(data.getData());
            }
            if (flag == 4) {
                fourthimage.setImageURI(data.getData());

            }
        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button press
        finish();
        return true;
    }
}