package com.ringpi.cric.networkconnect;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }

    public static boolean isHalfCentury(int runs) {
        boolean result = false;

        return result;
    }

    public static boolean isCentury(int runs) {
        boolean result = false;

        return result;
    }

    public static boolean isDuck(int runs) {
        boolean result = false;

        return result;
    }
}
