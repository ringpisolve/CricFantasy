package com.ringpi.cric.networkconnect;

public class Player {

    private int pid;
    private String name;
    private boolean isFreeAgent;
    private String franchiseName;

    public Player(int pid, String name, boolean isFreeAgent, String franchiseName) {
        this.pid = pid;
        this.name = name;
        this.isFreeAgent = isFreeAgent;
        this.franchiseName = franchiseName;
    }
}
