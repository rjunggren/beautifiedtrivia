package com.adaptionsoft.games.uglytrivia.model;

public class Player {
    private String name;
    private int purse;
    private int place;
    private boolean isInPenaltyBox;
    private boolean isGettingOutOfPenaltyBox;

    public Player(String name, int purse, boolean isInPenaltyBox) {
        this.name = name;
        this.purse = purse;
        this.isInPenaltyBox = isInPenaltyBox;
        this.isGettingOutOfPenaltyBox = false;
        this.place = 0;
    }

    public String getName() {
        return name;
    }

    public int getPurse() {
        return purse;
    }

    public boolean isInPenaltyBox() {
        return isInPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        isInPenaltyBox = inPenaltyBox;
    }

    public void addToPurse(int toAdd) {
        this.purse = this.purse + toAdd;
    }

    public boolean isGettingOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }

    public void setGettingOutOfPenaltyBox(boolean gettingOutOfPenaltyBox) {
        isGettingOutOfPenaltyBox = gettingOutOfPenaltyBox;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
