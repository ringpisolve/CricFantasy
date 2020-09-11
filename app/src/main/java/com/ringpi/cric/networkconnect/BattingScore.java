package com.ringpi.cric.networkconnect;

public class BattingScore {
public int runs = 0;
public int noOfFours = 0;
public int noOfSixes = 0;
public boolean isHalfCentury = false;
public boolean isCentury = false;
public boolean isDuck = false;

    public BattingScore(int runs, int noOfFours, int noOfSixes) {
        this.runs = runs;
        this.noOfFours = noOfFours;
        this.noOfSixes = noOfSixes;
        this.isHalfCentury = isHalfCentury;
        this.isCentury = isCentury;
        this.isDuck = isDuck;
    }

    public void setRuns(int runs){
        this.runs=runs;
    }
    public void setNoOfFours(int noOfFours){
        this.noOfFours=noOfFours;
    }
    public void setNoOfSixes(int noOfSixes){
        this.noOfSixes=noOfSixes;
    }

    public int getNoOfFours() {
        return noOfFours;
    }

    public int getRuns() {
        return runs;
    }

    public int getNoOfSixes() {
        return noOfSixes;
    }
}
