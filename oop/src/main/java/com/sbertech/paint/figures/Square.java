package com.sbertech.paint.figures;

import com.sbertech.paint.Color;
import com.sbertech.paint.Point;

public class Square extends Figure {

    private int side;

    public Square(Point point, int side) {
        super(point);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(side, 2);
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }

    @Override
    public void draw() {
        System.out.printf("Нарисован квадрат со стороной %d и координатами %d %d",
                side, point.getX(), point.getY());
    }

    @Override
    public void draw(Color color) {
        System.out.printf("Нарисован %s квадрат со стороной %d и координатами %d %d",
                color.getDescription(), side, point.getX(), point.getY());
    }
}
