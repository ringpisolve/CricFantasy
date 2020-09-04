package com.ringpi.cric.networkconnect;

    public class BowlingScore {

    public int maidens=0;
    public int wickets;
    public float economy=0;

        public BowlingScore() {

        }
    public BowlingScore( int maidens,int wickets,float economy) {

        this.maidens = maidens;
        this.wickets = wickets;
        this.economy = economy;

    }

        public void setMaidens(int maidens) {
            this.maidens = maidens;
        }

        public void setWickets(int wickets) {
            this.wickets = wickets;
        }

        public void setEconomy(float economy) {
            this.economy = economy;
        }

        public int getMaidens() {
            return maidens;
        }

        public float getEconomy() {
            return economy;
        }

        public int getWickets() {
            return wickets;
        }
    }
