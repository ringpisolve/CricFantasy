package com.ringpi.cric.networkconnect;

public class Player {

    private int pid;
    private String name;

    public boolean isFreeAgent() {
        return isFreeAgent;
    }

    public void setFreeAgent(boolean freeAgent) {
        isFreeAgent = freeAgent;
    }

    private boolean isFreeAgent;
    private String franchiseName;

    public boolean isInPlayingEleven() {
        return isInPlayingEleven;
    }

    public void setInPlayingEleven(boolean inPlayingEleven) {
        isInPlayingEleven = inPlayingEleven;
    }

    private boolean isInPlayingEleven;

    public Player(int pid, String name, boolean isFreeAgent, String franchiseName) {
        this.pid = pid;
        this.name = name;
        this.isFreeAgent = isFreeAgent;
        this.franchiseName = franchiseName;
    }
}
