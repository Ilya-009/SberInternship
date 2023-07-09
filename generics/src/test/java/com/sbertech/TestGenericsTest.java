package com.sbertech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TestGenericsTest {

    private static final TestGenerics TEST_GENERICS = new TestGenerics();
    private static final List<Double> DOUBLES;

    static {
        DOUBLES = new ArrayList<>();
        DOUBLES.add(14D);
        DOUBLES.add(15.4D);
    }

    /**
     * Task 1
     */
    @Test
    void countEvenTest() {
        long evenCount = TEST_GENERICS.countEven(DOUBLES);

        Assertions.assertEquals(evenCount, 1);
    }


    /**
     * Task 2
     */
    @Test
    void swapValuesTest() {
        TEST_GENERICS.swapValues(DOUBLES); // [15.4, 14]

        Assertions.assertArrayEquals(new Double[] { 15.4D, 14D }, DOUBLES.toArray());
    }
}