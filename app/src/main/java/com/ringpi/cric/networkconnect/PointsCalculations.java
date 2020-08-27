package com.ringpi.cric.networkconnect;

import java.util.ArrayList;
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

    public float calculateBowlerPoints(BowlingScore bowlingScoreObj) {
        float result = 0;
        bowlingScoreObj =new BowlingScore(3,3, (float) 5.2);
        result =result+bowlingScoreObj.maidens*bowlingPointsMap.get("M");
        result =result+bowlingScoreObj.wickets*bowlingPointsMap.get("W");
        result =result+bowlingScoreObj.economy*bowlingPointsMap.get("Econ");


        return result;
    }

    public float calculateFieldingPoints(FieldingScore fieldingScoreObj) {
        float result = 0;
        fieldingScoreObj=new FieldingScore(4,1);
        result=result+fieldingScoreObj.catches*fieldingPointsMap.get("catch");
        result=result+fieldingScoreObj.stumped*fieldingPointsMap.get("stumped");

        
        return result;
    }

    public float calculateSquadPointsForGivenMatch(
            ArrayList<Integer> squadPidList,
            HashMap<Integer, BattingScore> battingScoreHashMap,
            HashMap<Integer, BowlingScore> bowlingScoreHashMap,
            HashMap<Integer, FieldingScore> fieldingScoreHashMap
            ) {
        float result = 0;

        float totalBattingPoints = 0;
        for (Integer squadMember : squadPidList) {
            BattingScore battingScoreObj = battingScoreHashMap.get(squadMember);
            if ( battingScoreObj != null) {
                totalBattingPoints = totalBattingPoints + calculateBatsmanPoints(battingScoreObj);
            }
        }

        float totalBowlingPoints = 0;
        for (Integer squadMember : squadPidList) {
            BowlingScore bowlingScoreObj = bowlingScoreHashMap.get(squadMember);
            if ( bowlingScoreObj != null) {
                totalBowlingPoints = totalBowlingPoints + calculateBowlerPoints(bowlingScoreObj);
            }
        }

        float totalFieldingPoints = 0;
        for (Integer squadMember : squadPidList) {
            FieldingScore fieldingScoreObj = fieldingScoreHashMap.get(squadMember);
            if ( fieldingScoreObj != null) {
                totalFieldingPoints = totalFieldingPoints + calculateFieldingPoints(fieldingScoreObj);
            }
        }

        result = totalBattingPoints + totalBowlingPoints + totalFieldingPoints;
        return result;
    }
}
