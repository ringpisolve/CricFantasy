package com.ringpi.cric.networkconnect;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseUtils {

    public DocumentReference getTeamDocumentReference(String teamName, FirebaseFirestore fireDatabase) {
        return fireDatabase.collection("leagues")
                .document("kc-league")
                .collection("teams")
                .document(teamName);
    }
}
