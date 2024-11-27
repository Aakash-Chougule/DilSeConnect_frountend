package com.vivid.dilseconnect.Fragmets;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vivid.dilseconnect.Activites.account_settings;
import com.vivid.dilseconnect.Activites.help;
import com.vivid.dilseconnect.Activites.liked_by_others;
import com.vivid.dilseconnect.Activites.search_history;
import com.vivid.dilseconnect.Activites.settings;
import com.vivid.dilseconnect.Activites.view_profile;
import com.vivid.dilseconnect.Activites.you_liked_profiles;
import com.vivid.dilseconnect.MainActivity;
import com.vivid.dilseconnect.R;
import com.vivid.dilseconnect.Activites.purchase_plan;


public class account_fragment extends Fragment {
    LinearLayout purchase_plan_account_fragment;
    LinearLayout edit_profile_account_fragment,
            liked_profiles_account_fragment, liked_by_others_account_fragment, search_history_account_fragment,
            account_settings_account_fragment, settings_account_fragment, help_account_fragment, share_app_account_fragment;
    Intent intent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_fragment, container, false);
        purchase_plan_account_fragment = view.findViewById(R.id.purchase_plan_account_fragment);
        edit_profile_account_fragment = view.findViewById(R.id.edit_profile_account_fragment);
        liked_profiles_account_fragment = view.findViewById(R.id.liked_profiles_account_fragment);
        liked_by_others_account_fragment = view.findViewById(R.id.liked_by_others_account_fragment);
        search_history_account_fragment = view.findViewById(R.id.search_history_account_fragment);
        account_settings_account_fragment = view.findViewById(R.id.account_settings_account_fragment);
        settings_account_fragment = view.findViewById(R.id.settings_account_fragment);
        help_account_fragment = view.findViewById(R.id.help_account_fragment);
        share_app_account_fragment = view.findViewById(R.id.share_app_account_fragment);

//        // Set the drawable to the TextView
//        TextView purchasePlanTextView = view.findViewById(R.id.purchase_plan_text_view_account_fragment);
//        // Get the drawable from the resource
//        Drawable drawable = AppCompatResources.getDrawable(view.getContext(), R.drawable.noun_gold_crown);
//        // Set the bounds of the drawable
//        drawable.setBounds(0, 0, 40, 40);
//        // Set the drawable to the TextView
//        TextViewCompat.setCompoundDrawablesRelative(purchasePlanTextView, drawable, null, null, null);


        purchase_plan_account_fragment.setOnClickListener(v -> {
            // Handle the click event here
            intent = new Intent(getActivity(), purchase_plan.class);
            startActivity(intent);
        });
        edit_profile_account_fragment.setOnClickListener(v -> {
            intent = new Intent(getActivity(), view_profile.class);
            startActivity(intent);
        });
        liked_profiles_account_fragment.setOnClickListener(v -> {
            intent = new Intent(getActivity(), you_liked_profiles.class);
            startActivity(intent);
        });
        liked_by_others_account_fragment.setOnClickListener(v -> {
            intent = new Intent(getActivity(), liked_by_others.class);
            startActivity(intent);
        });
        search_history_account_fragment.setOnClickListener(v -> {
            intent = new Intent(getActivity(), search_history.class);
            startActivity(intent);
        });
        account_settings_account_fragment.setOnClickListener(v -> {
            intent = new Intent(getActivity(), account_settings.class);
            startActivity(intent);
        });
        settings_account_fragment.setOnClickListener(v -> {
            intent = new Intent(getActivity(), settings.class);
            startActivity(intent);
        });
        help_account_fragment.setOnClickListener(v -> {
            intent = new Intent(getActivity(), help.class);
            startActivity(intent);
        });
        share_app_account_fragment.setOnClickListener(v -> {
            shareApp();
        });


        return view;
    }
    private void shareApp() {
        // Create an Intent to share the app
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        // Set the type of data to be shared
        shareIntent.setType("text/plain");
        // Set the subject and body of the share
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Check out this awesome app!");
        // Set the text to be shared
        shareIntent.putExtra(Intent.EXTRA_TEXT, "I'm using this great app, you should try it too! [https://play.google.com/store/apps/details?id=com.bandainamcoent.dblegends_ww&pcampaignid=web_share]");
        // Start the share activity
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}