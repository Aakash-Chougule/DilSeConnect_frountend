package com.vivid.dilseconnect.Utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class hide_keyboard {
    public static void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
