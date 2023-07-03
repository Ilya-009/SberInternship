package com.sbertech.sound;

public class CatSounding implements Sounding {
    @Override
    public void sound() {
        System.out.println("мяу мяу");
    }

    public void catSleeping() {
        System.out.println("cat is sleeping");
    }

    public static void catCall() {
        System.out.println("кис - кис");
    }
}
