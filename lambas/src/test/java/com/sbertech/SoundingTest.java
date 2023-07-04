package com.sbertech;

import com.sbertech.sound.CatSounding;
import com.sbertech.sound.DogSounding;
import com.sbertech.sound.Sounding;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SoundingTest {

    @Test
    void sound() {
        List<Sounding> soundings = new ArrayList<>();

        CatSounding catSounding = new CatSounding();
        DogSounding dogSounding = new DogSounding();

        soundings.add(catSounding);
        soundings.add(dogSounding);
        soundings.forEach(Sounding::sound);

        soundings.add(new Sounding() {
            @Override
            public void sound() {
                System.out.println("кря кря");
            }
        });
        soundings.forEach(Sounding::sound);

        soundings.add(() -> System.out.println("хрю хрю"));
        soundings.forEach(Sounding::sound);

        soundings.add(catSounding::catSleeping);
        soundings.add(CatSounding::catCall);
        soundings.forEach(Sounding::sound);
    }
}