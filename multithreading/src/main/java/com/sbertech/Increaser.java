package com.sbertech;

public class Increaser extends Thread {

    private final ResourceProcessor resourceProcessor;

    public Increaser(ResourceProcessor resourceProcessor) {
        this.resourceProcessor = resourceProcessor;
    }

    @Override
    public void run() {
        resourceProcessor.increase();
    }
}
