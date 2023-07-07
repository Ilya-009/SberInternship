package com.sbertech;

import com.sbertech.task5.Decreaser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IncreaserTest {

    private static final Resource resource = new Resource();
    private static final ResourceProcessor resourceProcessor = new ResourceProcessor(resource);

    @BeforeEach
    void setUp() {
        resource.setCount(0);
    }

    /**
     * Task 4
     */
    @Test
    void testIncreaser() {
        new Increaser(resourceProcessor).start();
        new Increaser(resourceProcessor).start();
        new Increaser(resourceProcessor).start();
        new Increaser(resourceProcessor).start();
        new Increaser(resourceProcessor).start();
        new Increaser(resourceProcessor).start();
    }

    /**
     * Task 5
     */
    @Test
    void testWithDecreaser() {
        com.sbertech.task5.ResourceProcessor resourceProcessor1 = new com.sbertech.task5.ResourceProcessor(resource);
        resource.setCount(3);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                new com.sbertech.task5.Increaser(resourceProcessor1).start();
            }else{
                new Thread(new Decreaser(resourceProcessor1)).start();
            }
        }
    }
}