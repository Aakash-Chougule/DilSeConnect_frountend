package com.vivid.dilseconnect.Fragmets;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vivid.dilseconnect.Activites.Message_profile;
import com.vivid.dilseconnect.R;


public class message_fragment extends Fragment {
    LinearLayout profile1_message_fragment, profile2_message_fragment;
    ImageView profile_image_message_fragment, profile_image2_message_fragment;
    TextView name_message_fragment, name2_message_fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message_fragment_1, container, false);

        profile1_message_fragment = view.findViewById(R.id.profile1_message_fragment_layout);
        profile2_message_fragment = view.findViewById(R.id.profile2_message_fragment_layout);
        profile_image_message_fragment = view.findViewById(R.id.profile_image_message_fragment);
        profile_image2_message_fragment = view.findViewById(R.id.profile_image2_message_fragment);
        name_message_fragment = view.findViewById(R.id.name_message_fragment);
        name2_message_fragment = view.findViewById(R.id.name2_message_fragment);




        profile1_message_fragment.setOnClickListener(view1 -> {
            String name = name_message_fragment.getText().toString();
            Intent intent = new Intent(getActivity(), Message_profile.class);
            intent.putExtra("name", name);
            startActivity(intent);
        });
        profile2_message_fragment.setOnClickListener(view1 -> {
            String name = name2_message_fragment.getText().toString();

            Intent intent = new Intent(getActivity(), Message_profile.class);
            intent.putExtra("name", name);
            startActivity(intent);
        });

        return view;
    }

}