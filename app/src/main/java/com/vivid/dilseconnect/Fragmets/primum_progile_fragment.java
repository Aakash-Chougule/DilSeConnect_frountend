package com.vivid.dilseconnect.Fragmets;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vivid.dilseconnect.Activites.Home_Activity;
import com.vivid.dilseconnect.Activites.purchase_plan;
import com.vivid.dilseconnect.R;
import com.vivid.dilseconnect.Utils.NameTruncator;

import java.util.Objects;

public class primum_progile_fragment extends Fragment {

TextView name1_primimum_profile, name2_primimum_profile, name3_primimum_profile, name4_primimum_profile;
ImageView firstImage_primimum_profile, secondimage_primiumprofile, thirdImage_primimum_profile, forthImage_primimum_profile;
Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primum_progile_fragment, container, false);
        name1_primimum_profile = view.findViewById(R.id.name1_primimum_profile);
        name2_primimum_profile = view.findViewById(R.id.name2_primimum_profile);
        name3_primimum_profile = view.findViewById(R.id.name3_primimum_profile);
        name4_primimum_profile = view.findViewById(R.id.name4_primimum_profile);
        firstImage_primimum_profile = view.findViewById(R.id.firstImage_primimum_profile);
        secondimage_primiumprofile = view.findViewById(R.id.secondimage_primiumprofile);
        thirdImage_primimum_profile = view.findViewById(R.id.thirdImage_primimum_profile);
        forthImage_primimum_profile = view.findViewById(R.id.forthImage_primimum_profile);

        String originalName = "Akansha";
        String truncatedName = NameTruncator.truncateName(originalName);
        name1_primimum_profile.setText(truncatedName+", 24");
        String originalName2 = "Priyanka";
        String truncatedName2 = NameTruncator.truncateName(originalName2);
        name2_primimum_profile.setText(truncatedName2+", 26");
        String originalName3 = "pratiksha";
        String truncatedName3 = NameTruncator.truncateName(originalName3);
        name3_primimum_profile.setText(truncatedName3+", 24");
        String originalName4 = "selena";
        String truncatedName4 = NameTruncator.truncateName(originalName4);
        name4_primimum_profile.setText(truncatedName4+", 26");
        boolean isPremium = false;
        firstImage_primimum_profile.setOnClickListener(v -> {
            if (isPremium) {
                Intent intent = new Intent(getActivity(), purchase_plan.class);
                startActivity(intent);
            } else {
                new AlertDialog.Builder(getActivity())
                        .setTitle("primium")
                        .setMessage("Are you sure you want to purchase premium?")
                        .setPositiveButton("OK", (dialog, which) -> {
                            Intent intent = new Intent(getActivity(), purchase_plan.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "OK button clicked", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        })
                        .setNegativeButton("Cancel", (dialog, which) -> {
                            Toast.makeText(getActivity(), "Cancel button clicked", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        })

                        .show();
            }
        });
        secondimage_primiumprofile.setOnClickListener(v -> {
            intent = new Intent(getActivity(), purchase_plan.class);
            startActivity(intent);
        });
        thirdImage_primimum_profile.setOnClickListener(v -> {
            intent = new Intent(getActivity(), purchase_plan.class);
            startActivity(intent);
        });
        forthImage_primimum_profile.setOnClickListener(v -> {
            intent = new Intent(getActivity(), purchase_plan.class);
            startActivity(intent);
        });
        return view;
    }

}