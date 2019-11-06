package com.company;

abstract class Effect {

    int value;
    String description;

    Effect(int value, String description) {
        this.value = value;
        this.description = description;
    }

    abstract int getValue();

    abstract String getDescription();
}
