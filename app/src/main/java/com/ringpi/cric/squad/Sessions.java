package com.ringpi.cric.squad;

public class Sessions {
    private String name;



    private Sessions(){

    }
    private Sessions(String name){
        this.name=name;

    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

}