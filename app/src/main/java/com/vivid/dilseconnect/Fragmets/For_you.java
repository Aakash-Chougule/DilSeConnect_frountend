package com.vivid.dilseconnect.Fragmets;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vivid.dilseconnect.Activites.imageadapter;
import com.vivid.dilseconnect.Activites.profiles_preview;
import com.vivid.dilseconnect.R;


public class For_you extends Fragment {
    public interface OnImageClickListener {
        void onImageClick(int position);
    }

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] names = {"Akansha, 24", "Priya, 26"};
    int[] images = {R.drawable.girl_image, R.drawable.girl_image2};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_for_you, container, false);
        OnImageClickListener listener = position -> {
            // Handle the click event in the Fragment
            Intent intent = new Intent(getContext(), profiles_preview.class);
            intent.putExtra("imageResId", images[position]); // Pass image resource ID
            intent.putExtra("imageName", names[position]); // Pass image name
            startActivity(intent);
            Toast.makeText(getContext(), "Clicked image at position: " + position, Toast.LENGTH_SHORT).show();
        };
        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recycle_view_for_you);
        // Set RecyclerView properties
        recyclerView.setHasFixedSize(true);
        // Set layout manager
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new imageadapter(getContext(), images, names,listener);
        recyclerView.setAdapter(adapter);
        return view;

    }


}