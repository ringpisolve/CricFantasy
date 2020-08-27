package com.ringpi.cric.networkconnect;

import java.util.ArrayList;
import java.util.HashMap;

public class PointsCalculations {
    private static HashMap<String, Float> battingPointsMap;
    private static HashMap<String, Integer> bowlingPointsMap;
    private static HashMap<String, Float> fieldingPointsMap;


    // Instantiating the static map
    static
    {
        battingPointsMap = new HashMap<String, Float>();
        battingPointsMap.put("R", new Float(0.5));
        battingPointsMap.put("4s", new Float(0.5));
        battingPointsMap.put("6s", new Float(1));
        battingPointsMap.put("halfCentury", new Float(4));
        battingPointsMap.put("century", new Float(8));
        battingPointsMap.put("duck", new Float(-2));
    }

    static
    {
        bowlingPointsMap = new HashMap<String, Integer>();
        bowlingPointsMap.put("M",new Integer(4));
        bowlingPointsMap.put("W",new Integer(10));
        bowlingPointsMap.put("Econ",new Integer(-2));

    }

    public float calculateBatsmanPoints(BattingScore battingScoreObj) {
        float result = 0;
        // Temporary Dummy obj
        int runs = 21;
        battingScoreObj = new BattingScore(runs, 2, 0,
                Utils.isHalfCentury(runs), Utils.isCentury(runs),
                Utils.isDuck(runs));
        // Dummy object creation above to be deleted after json parsing.
        // Calculate points using battingScoreObj and battingPointsHashmap.
        result= result + battingScoreObj.runs * battingPointsMap.get("R");
        result= result + battingScoreObj.noOfFours * battingPointsMap.get("4s");
        result= result + battingScoreObj.noOfSixes * battingPointsMap.get("6s");
        if (battingScoreObj.isHalfCentury) {
            result = result + battingPointsMap.get("halfCentury");
        }
        if (battingScoreObj.isCentury) {
            result = result + battingPointsMap.get("century");
        }
        if (battingScoreObj.isDuck) {
            result = result + battingPointsMap.get("duck");
        }
        return result;
    }

    public int calculateBowlerPoints(BowlingScore battingScoreObj) {
        int result = 0;

        return result;
    }

    public int calculateFieldingPoints(FieldingScore battingScoreObj) {
        int result = 0;

        return result;
    }

    public float calculateSquadPointsForGivenMatch(
            ArrayList<Integer> squadPidList,
            HashMap<String, BattingScore> battingScoreHashMap,
            HashMap<String, BowlingScore> bowlingScoreHashMap,
            HashMap<String, BattingScore> fieldingScoreHashMap
            ) {
        int result = 0;

        return result;
    }
}
