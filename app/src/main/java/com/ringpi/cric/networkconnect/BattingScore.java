package com.ringpi.cric.networkconnect;

public class BattingScore {
private int runs = 0;
private int noOfFours = 0;
private int noOfSixes = 0;
private boolean isHalfCentury = false;
private boolean isCentury = false;
private boolean isDuck = false;

    public BattingScore(int runs, int noOfFours, int noOfSixes, boolean isHalfCentury, boolean isCentury, boolean isDuck) {
        this.runs = runs;
        this.noOfFours = noOfFours;
        this.noOfSixes = noOfSixes;
        this.isHalfCentury = isHalfCentury;
        this.isCentury = isCentury;
        this.isDuck = isDuck;
    }
}
