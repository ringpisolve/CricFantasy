package com.ringpi.cric.squad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.se.omapi.Session;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.ringpi.cric.R;

public class SquadActivity extends AppCompatActivity {
    private RecyclerView mFirestoreList;
    private FirebaseFirestore firebaseFirestore;
    private FirestoreRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squad);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFirestoreList=findViewById(R.id.firestore_list);
        firebaseFirestore=FirebaseFirestore.getInstance();

        Query query=firebaseFirestore.collection("leagues/kc-league/teams/rahul-team/squad");
        FirestoreRecyclerOptions<Sessions> options=new FirestoreRecyclerOptions.Builder<Sessions>()
                .setQuery(query, Sessions.class)
                .build();

        adapter=new FirestoreRecyclerAdapter<Sessions,SessionsViewHolder>(options) {

            @NonNull
            @Override
            public SessionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single,parent,false);
                return new SessionsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull SessionsViewHolder holder, int position, @NonNull Sessions model) {
                holder.faculty_name.setText(model.getname());

            }
        };
        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);


    }

    private class SessionsViewHolder extends RecyclerView.ViewHolder {
        private TextView faculty_name;

        public SessionsViewHolder(@NonNull View itemView) {
            super(itemView);
            faculty_name=itemView.findViewById(R.id.fac_name);

        }
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}