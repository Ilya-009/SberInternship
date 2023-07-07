package com.sbertech.task5;

public class Increaser extends Thread {

    private final com.sbertech.task5.ResourceProcessor resourceProcessor;

    public Increaser(com.sbertech.task5.ResourceProcessor resourceProcessor) {
        this.resourceProcessor = resourceProcessor;
    }

    @Override
    public void run() {
        try {
            resourceProcessor.increase();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
