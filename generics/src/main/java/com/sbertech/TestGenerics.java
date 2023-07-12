package com.sbertech;

import java.util.List;

public class TestGenerics {

    public <T extends Number> long countEven(List<T> list) {
        return list.stream()
                .filter(number -> number.intValue() % 2 == 0)
                .peek(System.out::println)
                .count();
    }

    public void swapValues(List<? extends Number> numbers) {
        swapValuesHelper(numbers);
    }

    private <T extends Number> void swapValuesHelper(List<T> numbers) {
        T cachedElem = numbers.get(0);
        numbers.set(0, numbers.get(1));
        numbers.set(1, cachedElem);
    }
}
