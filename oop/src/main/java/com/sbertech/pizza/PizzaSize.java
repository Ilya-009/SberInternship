package com.sbertech.pizza;

public enum PizzaSize {
    SMALL("маленькая"),
    MEDIUM("средняя"),
    BIG("большая");

    private final String desc;

    PizzaSize(String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return desc;
    }
}
