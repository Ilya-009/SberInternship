package com.sbertech.paint.figures;

import com.sbertech.paint.Color;
import com.sbertech.paint.Point;

public class Circle extends Figure {
    private int radius;

    public Circle(Point point, int radius) {
        super(point);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.printf("Нарисован круг с радиусом %d и координатами %d %d", radius, point.getX(), point.getY());
    }

    @Override
    public void draw(Color color) {
        System.out.printf("Нарисован %s круг с радиусом %d и координатами %d %d", color.getDescription(), radius, point.getX(), point.getY());
    }
}
