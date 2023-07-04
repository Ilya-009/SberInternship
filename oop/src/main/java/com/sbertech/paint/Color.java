package com.sbertech.paint;

public enum Color {
    BLUE("синий"),
    RED("красный"),
    PINK("розовый"),
    YELLOW("желтый"),
    GREEN("зеленый");

    private final String desc;

    Color(String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return desc;
    }
}
