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

    public int calculateBatsmanPoints(BattingScore battingScoreObj) {
        int result = 0;
        // Temporary Dummy obj
        int runs = 21;
        battingScoreObj = new BattingScore(runs, 2, 0,
                Utils.isHalfCentury(runs), Utils.isCentury(runs),
                Utils.isDuck(runs));
        // Dummy object creation above to be deleted after json parsing.
        // Calculate points using battingScoreObj and battingPointsHashmap.

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
