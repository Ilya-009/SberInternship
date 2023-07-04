package com.sbertech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MainTest {

    @Test
    void task1() {
        int[] streamValues = { 15, 50, 1, 10, 8, 4, 7, 54, 61, 5 };
        IntStream intStream = IntStream.of(streamValues);
        int[] orderedTwoDigitNumbers = intStream.filter(el -> getDigitsCount(el) == 2).sorted().toArray();
        Assertions.assertArrayEquals(new int[] { 10, 15, 50, 54, 61 }, orderedTwoDigitNumbers);

        intStream = IntStream.of(streamValues);
        double averageValue = intStream.average().orElse(0);
        Assertions.assertEquals(averageValue, 21.5);
    }

    @Test
    void task3() {
        Random random = new Random();
        List<String> strValues = new ArrayList<>(List.of("string 1", "string 2", "string 3"));
        Long[] generatedNumbers = IntStream.range(1, 4).mapToObj(index -> random.nextLong(100)).toArray(Long[]::new);

        AtomicInteger index = new AtomicInteger(-1);
        Stream<StreamContainer> streamContainerStream = strValues.stream()
                .map(str -> {
                    index.getAndIncrement();
                    return new StreamContainer(str, generatedNumbers[index.get()]);
                });

        List<StreamContainer> streamContainers = streamContainerStream.toList();

        System.out.println("StreamContainers' counts: ");
        Long[] containerCounts = streamContainers.stream().map(StreamContainer::getCount).toArray(Long[]::new);
        Assertions.assertArrayEquals(generatedNumbers, containerCounts);

        Map<String, Long> resultMap = streamContainers.stream().collect(Collectors.toMap(StreamContainer::getName, StreamContainer::getCount));
        System.out.println(resultMap);
    }

    @Test
    void task4() {
        Map<String, List<Long>> map = new HashMap<>();
        map.put("name 1", new ArrayList<>(List.of(1L, 2L, 3L)));
        map.put("name 2", new ArrayList<>(List.of(1L, 2L, 3L, 4L, 5L)));

        Stream<StreamContainer> convertedMapToStream = map.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(value -> new StreamContainer(entry.getKey(), value)));
        List<StreamContainer> streamContainerList = convertedMapToStream.toList();
        long count = streamContainerList.stream().count();

        Assertions.assertEquals(count, 8);
    }

    @Test
    void task5() {
        String booleanString = "0111100011";

        Stream<Boolean> booleanStream = booleanString.chars().mapToObj(el -> (char) el != '0');
        boolean logicAndResult = booleanStream.allMatch(stmt -> stmt);
        Assertions.assertFalse(logicAndResult);
    }

    private int getDigitsCount(int digit) {
        return Math.toIntExact(String.valueOf(digit).chars()
                .mapToObj(i -> (char)i)
                .filter(Character::isDigit)
                .count());
    }
}