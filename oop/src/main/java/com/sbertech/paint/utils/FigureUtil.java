package com.sbertech.paint.utils;

import com.sbertech.paint.Color;
import com.sbertech.paint.Drawable;
import com.sbertech.paint.figures.Figure;

public class FigureUtil {
    public static double area(Figure figure) {
        return figure.area();
    }

    public static double perimeter(Figure figure) {
        return figure.perimeter();
    }

    public static void draw(Drawable drawable) {
        drawable.draw();
    }

    public static void draw(Drawable drawable, Color color) {
        drawable.draw(color);
    }
}
