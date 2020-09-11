package com.ringpi.cric.networkconnect;

public class FieldingScore {
   public int catches=0;
   public int stumped=0;

    public FieldingScore(int catches,int stumped) {

        this.catches = catches;
        this.stumped = stumped;
    }
    public void setCatches(int catches){
        this.catches=catches;
    }
    public void setStumped(int stumped){
        this.stumped=stumped;
    }
}
