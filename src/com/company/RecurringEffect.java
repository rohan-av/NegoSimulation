package com.company;

public class RecurringEffect extends Effect{

    RecurringEffect(int value, String description) {
        super(value, description);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
