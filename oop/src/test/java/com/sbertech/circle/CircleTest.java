package com.sbertech.circle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    static Circle circle;

    @BeforeAll
    static void beforeAll() {
        circle = new Circle(5, "blue");
    }

    @Test
    void area() {
        double expected = 78.53981633974483d;
        assertEquals(expected, circle.area());
    }

    @Test
    void perimeter() {
        double expected = 31.41592653589793d;
        assertEquals(expected, circle.perimeter());
    }

    @Test
    void testToString() {
        System.out.println(circle.toString());
    }
}