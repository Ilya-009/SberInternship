package com.sbertech.matrix;

import java.util.Arrays;

class Matrix {
    private final int rowCount;
    private final int columnCount;
    double[][] values;

    public Matrix(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        values = new double[this.rowCount][this.columnCount];

        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.columnCount; j++) {
                values[i][j] = Math.random() % 10;
            }
        }
    }

    public void setValue(int rowIndex, int colIndex, double value) {
        if (rowIndex >= rowCount || colIndex >= columnCount) {
            throw new ArrayIndexOutOfBoundsException();
        }

        values[rowIndex][colIndex] = value;
    }

    void sumTwoMatrix(double[][] matrix2) {
        double[][] matrixSum = new double[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                double numMatrix1 = values[i][j];
                double numMatrix2 = matrix2[i][j];
                matrixSum[i][j] = numMatrix1 + numMatrix2;
            }
        }

        printMatrix(matrixSum);
    }

    public double[][] multiplyToNumber(int inc) {
        return Arrays.stream(values)
                .map(row ->
                        Arrays.stream(row).map(cell -> cell * inc)
                        .toArray())
                .toArray(double[][]::new);
    }

    double[][] multiplyMatrices(double[][] secondMatrix) {
        double[][] result = new double[rowCount][columnCount];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = multiplyMatricesCell(values, secondMatrix, i, j);
            }
        }

        return result;
    }

    public void printMatrix() {
        printMatrix(values);
    }

    public void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double cellValue : row) {
                System.out.print(cellValue + " ");
            }
            System.out.println();
        }
    }

    private double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;

        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }

        return cell;
    }
}