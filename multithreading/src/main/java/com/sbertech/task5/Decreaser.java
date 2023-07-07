package com.sbertech.task5;

public class Decreaser implements Runnable {
    private final ResourceProcessor resource;

    public Decreaser(ResourceProcessor resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            resource.decrease();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}