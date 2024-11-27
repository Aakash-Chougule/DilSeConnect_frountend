package com.vivid.dilseconnect.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class shared_prefrence_util {
    // SharedPreferences constants
    private static final String PREF_NAME = "your_app_prefs";
    private static SharedPreferences sharedPreferences;

    public static void initialize(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    // Specific methods for user data
    public static void putName(String name) {
        putString("name", name);
    }

    // Other methods for user data
    public static String getName(String defaultValue) {
        return getString("name", defaultValue);
    }

    public static void putEmail(String email) {
        putString("email", email);
    }

    public static String getEmail(String defaultValue) {
        return getString("email", defaultValue);
    }

    public static void putLocation(String location) {
        putString("location", location);
    }

    public static String getLocation(String defaultValue) {
        return getString("location", defaultValue);
    }

    public static void putDateOfBirth(String dob) {
        putString("dob", dob);
    }

    public static String getDateOfBirth(String defaultValue) {
        return getString("dob", defaultValue);
    }

    public static void putGender(String gender) {
        putString("gender", gender);
    }

    public static String getGender(String defaultValue) {
        return getString("gender", defaultValue);
    }

    public static void putMobileNo(String mobileNo) {
        putString("mobile_no", mobileNo);
    }

    public static String getMobileNo(String defaultValue) {
        return getString("mobile_no", defaultValue);
    }

    public static void putProfilePreviewName(String name) {
        putString("profile_preview_name", name);
    }

    public static String getProfilePreviewName(String defaultValue) {
        return getString("profile_preview_name", defaultValue);
    }

}
