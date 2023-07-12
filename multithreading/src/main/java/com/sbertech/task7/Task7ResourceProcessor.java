package com.sbertech.task7;

import com.sbertech.Resource;

public class Task7ResourceProcessor {

    private final Resource resource;

    public Task7ResourceProcessor(Resource resource) {
        this.resource = resource;
        resource.setCount(0);
    }

    public synchronized void increase() throws InterruptedException {
        if (resource.getCount() >= 5) {
            wait();
        }

        resource.setCount(resource.getCount() + 1);
        System.out.println(resource.getCount());

        notify();
    }

    public synchronized void decrease() throws InterruptedException {
        while (resource.getCount() < 1) {
            wait();
        }

        resource.setCount(resource.getCount() - 1);
        System.out.println(resource.getCount());

        notify();
    }
}
