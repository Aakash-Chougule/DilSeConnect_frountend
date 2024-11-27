package com.vivid.dilseconnect.Utils;

public class NameTruncator {
    public static String truncateName(String name) {
        if (name.length() > 6) {
            return name.substring(0, 6) + "...";
        } else {
            return name;}
    }
}
