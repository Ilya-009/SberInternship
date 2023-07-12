package com.sbertech.task7;

public class Task7Decreaser implements Runnable {
    private final Task7ResourceProcessor resourceProcessor;

    public Task7Decreaser(Task7ResourceProcessor resource) {
        this.resourceProcessor = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                resourceProcessor.decrease();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}