package com.ringpi.cric.networkconnect;

public class Player {

    private int pid;
    private String name;
    private boolean isFreeAgent;
    private String franchiseName;
    private boolean isInPlayingEleven;

    public boolean isFreeAgent() {
        return isFreeAgent;
    }

    public void setFreeAgent(boolean freeAgent) {
        isFreeAgent = freeAgent;
    }

    public boolean isInPlayingEleven() {
        return isInPlayingEleven;
    }

    public void setInPlayingEleven(boolean inPlayingEleven) {
        isInPlayingEleven = inPlayingEleven;
    }


    public Player(int pid, String name, boolean isFreeAgent, String franchiseName) {
        this.pid = pid;
        this.name = name;
        this.isFreeAgent = isFreeAgent;
        this.franchiseName = franchiseName;
    }
}
