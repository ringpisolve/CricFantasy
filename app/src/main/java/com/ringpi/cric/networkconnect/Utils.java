package com.ringpi.cric.networkconnect;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Utils {

    public String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }

    public static boolean isHalfCentury(int runs) {
        boolean result = false;
        if(runs>=50 && runs<100){
            result=true;
        }

        return result;
    }

    public static boolean isCentury(int runs) {
        boolean result = false;
        if(runs>=100){
            result=true;
        }


        return result;
    }

    public static boolean isDuck(int runs) {
        boolean result = false;
        if(runs==0){
            result=true;
        }
        return result;
    }

    public  static ArrayList<Integer> getCurrentMatchPlayersPIDList(String jsonString) {
        ArrayList<Integer> result = new ArrayList<>();
        try {
            JSONObject rootObj = new JSONObject(jsonString);
            JSONObject dataObj = rootObj.getJSONObject("data");
            JSONArray teamArray = dataObj.getJSONArray("team");

            JSONObject teamOneObj = (JSONObject) teamArray.get(0);
            JSONArray teamOnePlayersArray = teamOneObj.getJSONArray("players");
            for (int i = 0; i < teamOnePlayersArray.length(); i++) {
                JSONObject player = (JSONObject) teamOnePlayersArray.get(i);
                result.add(Integer.valueOf(player.getString("pid")));
            }

            JSONObject teamTwoObj = (JSONObject) teamArray.get(1);
            JSONArray teamTwoPlayersArray = teamTwoObj.getJSONArray("players");
            for (int i = 0; i < teamTwoPlayersArray.length(); i++) {
                JSONObject player = (JSONObject) teamOnePlayersArray.get(i);
                result.add(Integer.valueOf(player.getString("pid")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;

    }

    public ArrayList<Integer> getSquadPlayingInCurrentMach(String jsonString) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> currentMatchPlayerList = getCurrentMatchPlayersPIDList(jsonString);
        ArrayList<Integer> yourPlayingElevenPIDList =
                new FirebaseUtils().getPlayingElevenPIDList("rahul-team");
        for (Integer pid : yourPlayingElevenPIDList) {
            if (currentMatchPlayerList.contains(pid)) {
                result.add(pid);
            }
        }
        return result;

    }

    public void parseSquadPlayingInCurrentMatch(ArrayList<Integer> squadPlayingInCurrentMatch,
                                           String jsonString) {


    }

    public void getBowlingFantasyData(ArrayList<Integer> squadPlayingInCurrentMatch, JSONArray bowlingArray) {

    }

    public void getBattingFantasyData(ArrayList<Integer> squadPlayingInCurrentMatch, JSONArray battingArray) {

    }

    public void getFieldingFantasyData(ArrayList<Integer> squadPlayingInCurrentMatch, JSONArray fieldingArray) {

    }
}
