package com.sbertech.phone;

import java.util.Arrays;

public class Phone {
    private String number;
    private String model;
    private int weight;

    public Phone() {
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(String number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public void receiveCall(String name) {
        System.out.printf("Звонит %s", name);
    }

    public void receiveCall(String name, String number) {
        System.out.printf("Звонит %s с номера %s", name, number);
    }

    public String getNumber() {
        return this.number;
    }

    public void sendMessage(String[] telNumbers) {
        Arrays.stream(telNumbers).forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }
}