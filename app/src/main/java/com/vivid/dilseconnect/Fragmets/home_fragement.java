package com.vivid.dilseconnect.Fragmets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.google.android.material.chip.Chip;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vivid.dilseconnect.R;
import com.vivid.dilseconnect.databinding.FragmentHomeBinding;


public class home_fragement extends Fragment {
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Set initial fragment (optional)
        replaceFragment(new Discover());
        Chip discoverChip = binding.discoverChip;
        Chip forYouChip = binding.forYouChip;
        discoverChip.setOnClickListener(v -> {
            replaceFragment(new Discover());
            discoverChip.setChecked(true);
            forYouChip.setChecked(false);
        });
        forYouChip.setOnClickListener(v -> {
            replaceFragment(new For_you());
            forYouChip.setChecked(true);
            discoverChip.setChecked(false);
        });
        return view;
    }

    private void replaceFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}