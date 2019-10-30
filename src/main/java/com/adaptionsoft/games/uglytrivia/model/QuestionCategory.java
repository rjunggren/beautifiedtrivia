package com.adaptionsoft.games.uglytrivia.model;

public enum QuestionCategory {

    POP("Pop"), SCIENCE("Science"), SPORTS("Sports"), ROCK("Rock");

    private String label;

    QuestionCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
