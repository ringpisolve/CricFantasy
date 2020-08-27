package com.ringpi.cric.networkconnect;

import java.util.HashMap;

public class PointsCalculations {
    private static HashMap<String, Float> battingPointsMap;
    private static HashMap<String, Float> bowlingPointsMap;
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
        bowlingPointsMap = new HashMap<String,Float>();
        bowlingPointsMap.put("M",new Float(4));
        bowlingPointsMap.put("W",new Float(10));
        bowlingPointsMap.put("Econ",new Float(-2));

    }
    static {
        fieldingPointsMap= new HashMap<String, Float>();
        fieldingPointsMap.put("catch",new Float(4));
        fieldingPointsMap.put("stumped",new Float(6));
     //TODO add run out    fieldingPointsMap.put("runout",new Float(6));

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
}
