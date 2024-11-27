package com.vivid.dilseconnect.Utils;

import java.util.Random;

public class OTPUtils {
    public static String generateOTP(int length) {
        Random random = new Random();StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
}
