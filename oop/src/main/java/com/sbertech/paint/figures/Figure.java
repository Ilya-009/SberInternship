package com.sbertech.paint.figures;

import com.sbertech.paint.Drawable;
import com.sbertech.paint.Point;

public abstract class Figure implements Drawable {
    protected Point point;

    public Figure(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public abstract double area();
    public abstract double perimeter();
}
