package com.vivid.dilseconnect.Activites;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;
import com.vivid.dilseconnect.R;
import com.vivid.dilseconnect.Utils.ExpandableTextViewHelper;

public class help extends AppCompatActivity {

    
    ExpandableTextViewHelper expandableTextViewHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_help);
        MaterialCardView how_do_i_create_an_account = findViewById(R.id.how_do_i_create_an_account);
        TextView ans_how_do_i_create_an_account = findViewById(R.id.ans_how_do_i_create_an_account);
        expandableTextViewHelper = new ExpandableTextViewHelper(how_do_i_create_an_account, ans_how_do_i_create_an_account);

        // Set up click listener
        how_do_i_create_an_account.setOnClickListener(v -> expandableTextViewHelper.toggleVisibility(ans_how_do_i_create_an_account));

        MaterialCardView cardView2 = findViewById(R.id.i_create_an_account);
        TextView answerTextView2 = findViewById(R.id.ans_i_create_an_account);
        cardView2.setOnClickListener(v -> expandableTextViewHelper.toggleVisibility(answerTextView2));



    }


}