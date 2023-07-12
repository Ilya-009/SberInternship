package com.sbertech.task7;

public class Task7Increaser extends Thread {

    private final Task7ResourceProcessor resourceProcessor;

    public Task7Increaser(Task7ResourceProcessor resourceProcessor) {
        this.resourceProcessor = resourceProcessor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                resourceProcessor.increase();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
