/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ringpi.cric.networkconnect;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.ringpi.cric.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample Activity demonstrating how to connect to the network and fetch raw
 * HTML. It uses a Fragment that encapsulates the network operations on an AsyncTask.
 *
 * This sample uses a TextView to display output.
 */
public class AddMatchActivity extends AppCompatActivity implements DownloadCallback {

    // Reference to the TextView showing fetched data, so we can clear it with a button
    // as necessary.
    private TextView mDataText;
    private Button mFetchButton;

    // Keep a reference to the NetworkFragment which owns the AsyncTask object
    // that is used to execute network ops.
    private NetworkFragment mNetworkFragment;

    // Boolean telling us whether a download is in progress, so we don't trigger overlapping
    // downloads with consecutive button clicks.
    private boolean mDownloading = false;
    private Button calpoints;
    private TextView Points;
    private String mJsonstring;
    private String spinnerteam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);
        mDataText = (TextView) findViewById(R.id.data_text);
        mFetchButton = (Button) findViewById(R.id.fetch_button);
        calpoints =(Button) findViewById(R.id.cal_points);
       Points=(TextView) findViewById(R.id.points);

        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
        CollectionReference subjectsRef = rootRef.collection("matches");
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        List<String> subjects = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        subjectsRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String subject = document.getString("fixture");
                        subjects.add(subject);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });

        FirebaseFirestore rootRef1 = FirebaseFirestore.getInstance();
        CollectionReference subjectsRef1 = rootRef1.collection("team-list");
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner2);

        List<String> subjects1 = new ArrayList<>();
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, subjects1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        subjectsRef1.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String subject1 = document.getString("name");
                        subjects1.add(subject1);
                    }
                    adapter1.notifyDataSetChanged();
                }
            }
        });



  calpoints.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
         /* PointsCalculations pc =new PointsCalculations();
          String mm = String.valueOf(pc.calculateBatsmanPoints(null));
          Points.setText(mm);

        */
          spinnerteam = spinner1.getSelectedItem().toString();
         Intent intent=new Intent(AddMatchActivity.this,SquadPointsCalculation.class);
         intent.putExtra("jsonstring",mJsonstring);
         intent.putExtra("team",spinnerteam);
         startActivity(intent);




      }
  });




        mFetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDownload();
            }
        });
        mNetworkFragment = NetworkFragment.getInstance(getSupportFragmentManager(), "https://cricapi.com/api/fantasySummary?apikey=dA5xK2fQ47hbInUkC4413UMwIwh2&unique_id=1227889");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // When the user clicks FETCH, fetch the first 500 characters of
            // raw HTML from www.google.com.
            case R.id.fetch_action:
                startDownload();
                return true;
            // Clear the text and cancel download.
            case R.id.clear_action:
                finishDownloading();
                mDataText.setText("");
                return true;
        }
        return false;
    }

    private void startDownload() {
        if (!mDownloading && mNetworkFragment != null) {
            // Execute the async download.
            mNetworkFragment.startDownload();
            mDownloading = true;
        }
    }

    @Override
    public void updateFromDownload(String result) {
        if (result != null) {
            mDataText.setText(result);

           mJsonstring=result;
            BowlingScore bowlingScore=new BowlingScore();
            int maidens;
            int wickets;
            float economy;


                try {
                    JSONObject resultObj = new JSONObject(result);
                    JSONObject dataObj = resultObj.getJSONObject("data");
                    JSONArray matchBowlingArray = dataObj.getJSONArray("bowling");
                    JSONObject teamOneBowlingObj = (JSONObject) matchBowlingArray.get(0);
                    JSONArray teamOneScoresArray = teamOneBowlingObj.getJSONArray("scores");



                    for(int i=0;i<=teamOneBowlingObj.length();i++) {

                        JSONObject teamOnePlayerOneBowlingObj = (JSONObject) teamOneScoresArray.get(i);
                        maidens = Integer.parseInt(teamOnePlayerOneBowlingObj.getString("M"));
                        wickets = Integer.parseInt(teamOnePlayerOneBowlingObj.getString("W"));
                        economy = Float.parseFloat(teamOnePlayerOneBowlingObj.getString("Econ"));
                        bowlingScore.setMaidens(maidens);
                        bowlingScore.setWickets(wickets);
                        bowlingScore.setEconomy(economy);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }



        } else {
            mDataText.setText(getString(R.string.connection_error));
        }

    }

    @Override
    public NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo;
    }

    @Override
    public void finishDownloading() {
        mDownloading = false;
        if (mNetworkFragment != null) {
            mNetworkFragment.cancelDownload();
        }
    }

    @Override
    public void onProgressUpdate(int progressCode, int percentComplete) {
        switch(progressCode) {
            // You can add UI behavior for progress updates here.
            case Progress.ERROR:
                break;
            case Progress.CONNECT_SUCCESS:
                break;
            case Progress.GET_INPUT_STREAM_SUCCESS:
                break;
            case Progress.PROCESS_INPUT_STREAM_IN_PROGRESS:
                mDataText.setText("" + percentComplete + "%");
                break;
            case Progress.PROCESS_INPUT_STREAM_SUCCESS:
                break;
        }
    }
}
