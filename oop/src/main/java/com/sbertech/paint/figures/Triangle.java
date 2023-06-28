package com.sbertech.paint.figures;

import com.sbertech.paint.Color;
import com.sbertech.paint.Point;

public class Triangle extends Figure {

    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(Point point, int sideA, int sideB, int sideC) {
        super(point);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double perimeter = perimeter();

        return Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public void draw() {
        System.out.printf("Нарисовантреугольник со сторонами: %d, %d, %d и координатами %d %d",
                sideA, sideB, sideC, point.getX(), point.getY());
    }

    @Override
    public void draw(Color color) {
        System.out.printf("Нарисован %s треугольник со сторонами: %d, %d, %d и координатами %d %d",
                color.getDescription(), sideA, sideB, sideC, point.getX(), point.getY());
    }
}
