package com.sbertech.paint.utils;

import com.sbertech.paint.Color;
import com.sbertech.paint.Point;
import com.sbertech.paint.figures.Circle;
import com.sbertech.paint.figures.Rectangle;
import com.sbertech.paint.figures.Square;
import com.sbertech.paint.figures.Triangle;
import org.junit.jupiter.api.Test;

class FigureUtilTest {

    private static final Point point = new Point(10, 10);

    @Test
    void area() {
        System.out.println(FigureUtil.area(new Circle(point, 5)));
    }

    @Test
    void perimeter() {
        System.out.println(FigureUtil.perimeter(new Triangle(point,1, 2, 3)));
    }

    @Test
    void draw() {
        FigureUtil.draw(new Square(point,3));
    }

    @Test
    void testDraw() {
        FigureUtil.draw(new Rectangle(point, 2, 4), Color.GREEN);
    }
}