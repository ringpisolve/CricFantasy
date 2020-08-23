package com.ringpi.cric.networkconnect;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public DocumentReference getTeamDocumentReference(String teamName, FirebaseFirestore fireDatabase) {
        return fireDatabase.collection("leagues")
                .document("kc-league")
                .collection("teams")
                .document(teamName);
    }

    public String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }
}
