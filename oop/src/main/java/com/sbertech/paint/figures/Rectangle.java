package com.sbertech.paint.figures;

import com.sbertech.paint.Color;
import com.sbertech.paint.Point;

public class Rectangle extends Figure {

    private int height;
    private int width;

    public Rectangle(Point point, int height, int width) {
        super(point);
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public double area() {
        return height * width;
    }

    @Override
    public double perimeter() {
        return 2 * (height + width);
    }

    @Override
    public void draw() {
        System.out.printf("Нарисован прямоугольник с высотой %d и шириной %d и координатами %d %d",
                height, width, point.getX(), point.getY());
    }

    @Override
    public void draw(Color color) {
        System.out.printf("Нарисован %s прямоугольник с высотой %d и шириной %d и координатами %d %d",
                color.getDescription(), height, width, point.getX(), point.getY());
    }
}
