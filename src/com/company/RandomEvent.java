package com.company;

public class RandomEvent extends Effect {

    int lowerBound;
    int upperBound;

    RandomEvent(int value, String description, int lowerBound, int upperBound) {
        super(value, description);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    int getValue() {
        return (int)(Math.random()*((upperBound - lowerBound) + 1)) + lowerBound;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
