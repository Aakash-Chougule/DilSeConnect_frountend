package com.vivid.dilseconnect.Utils;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class ExpandableTextViewHelper {// Class to handle the expandable text view
    // Private instance variables to hold the views
    private MaterialCardView cardView;
    private TextView answerTextView;

    public ExpandableTextViewHelper(MaterialCardView cardView, TextView answerTextView) {
        // Initialize the helper with the provided views
        this.cardView = cardView;
        this.answerTextView = answerTextView;
    }

    public void toggleVisibility(TextView answerTextView) {
        int newVisibility = (answerTextView.getVisibility() ==View.GONE) ? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
        answerTextView.setVisibility(newVisibility);
    }
}
