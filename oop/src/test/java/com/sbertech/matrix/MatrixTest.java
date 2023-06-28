package com.sbertech.matrix;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MatrixTest {
    static Matrix matrix;
    static final double[][] anotherMatrix = new double[][] {
            {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}
    };

    @BeforeAll
    static void beforeAll() {
        matrix = new Matrix(5, 5);
        matrix.printMatrix();

        System.out.println();
    }

    @Test
    void setValue() {
        matrix.setValue(0, 0, 10);
        matrix.printMatrix();
    }

    @Test
    void sumTwoMatrix() {
        matrix.sumTwoMatrix(anotherMatrix);
    }

    @Test
    void multiplyToNumber() {
        int increment = 2;

        matrix.printMatrix(matrix.multiplyToNumber(increment));
    }

    @Test
    void multiplyMatrices() {
        matrix.printMatrix(matrix.multiplyMatrices(anotherMatrix));
    }

    @Test
    void printMatrix() {
        matrix.printMatrix();
    }
}