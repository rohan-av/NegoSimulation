package com.company;

public class RandomEffect extends Effect {

    float probability;

    RandomEffect(int value, String description, float probability) {
        super(value, description);
        this.probability = probability;
    }

    @Override
    int getValue() {
        if (happens()) {
            return value;
        }
        return 0;
    }

    boolean happens() {
        return Math.random() <= probability;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
