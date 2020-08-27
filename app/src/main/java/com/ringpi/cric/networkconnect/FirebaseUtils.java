package com.ringpi.cric.networkconnect;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class FirebaseUtils {

    public DocumentReference getTeamDocumentReference(String teamName, FirebaseFirestore fireDatabase) {
        return fireDatabase.collection("leagues")
                .document("kc-league")
                .collection("teams")
                .document(teamName);
    }

    public ArrayList<Integer> getSquadPidList(String teamName) {
        ArrayList<Integer> result = new ArrayList<>();

        return result;
    }
}
