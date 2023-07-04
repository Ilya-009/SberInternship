package com.sbertech.circle;

public class Circle {
    private final double radius;
    private final String color;

    public Circle(float radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color=" + color +
                ", square=" + area() +
                ", perimeter=" + perimeter() +
                "}";
    }
}
