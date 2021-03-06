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



public class FirebaseUtils {

    public DocumentReference getTeamDocumentReference(String teamName, FirebaseFirestore fireDatabase) {
        return fireDatabase.collection("leagues")
                .document("kc-league")
                .collection("teams")
                .document(teamName);
    }

    public static ArrayList<Integer> getPlayingElevenPIDList(String teamName) {
        ArrayList<Integer> list = new ArrayList<>();
        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();

        rootRef.collection("leagues/kc-league/teams/"+teamName+"/squad")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Boolean playingEleven=document.getBoolean("isInPlayingEleven");
                                String ss = document.getString("pid");

                                    if(playingEleven==true) {
                                        list.add(Integer.valueOf(ss));


                                        Log.d("TAG", String.valueOf(list));
                                    }





                            }
                        }
                    }
                });


        return list;
    }
    public static ArrayList<Integer> getTeamPIDList(String teamName) {
        ArrayList<Integer> list = new ArrayList<>();
        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();

        rootRef.collection("leagues/kc-league/teams/"+teamName+"/squad")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                String ss = document.getString("pid");
                                list.add(Integer.valueOf(ss));

                                Log.d("TAG", String.valueOf(list));




                            }
                        }
                    }
                });


        return list;
    }
}
