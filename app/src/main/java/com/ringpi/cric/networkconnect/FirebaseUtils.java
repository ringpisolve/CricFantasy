package com.ringpi.cric.networkconnect;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class FirebaseUtils {

    public DocumentReference getTeamDocumentReference(String teamName, FirebaseFirestore fireDatabase) {
        return fireDatabase.collection("leagues")
                .document("kc-league")
                .collection("teams")
                .document(teamName);
    }

    public List<String> getPlayingElevenPIDList(String teamName) {
        List<String> list = new ArrayList<>();
        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();

        rootRef.collection("leagues/kc-league/teams/rahul-team/playing11")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                    String ss = document.getString("pid");
                                    list.add(ss);

                                    Log.d("TAG", ss);




                            }
                        }
                    }
                });


        return list;
    }
}
