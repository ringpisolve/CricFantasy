package com.ringpi.cric.networkconnect;

public class BowlingScore {
    public float overs=0;
    public int maidens=0;
    public int runs = 0;
    public int wickets;
    public float economy=0;
    public int dots=0;
    public int noOfFours = 0;
    public int noOfSixes;

    public BowlingScore( float overs,int maidens,int runs,int wickets,float economy, int dots, int noOfFours, int noOfSixes) {


        this.overs = overs;
        this.maidens = maidens;
        this.runs = runs;
        this.wickets = wickets;
        this.economy = economy;
        this.dots = dots;
        this.noOfFours = noOfFours;
        this.noOfSixes = noOfSixes;
    }
}
