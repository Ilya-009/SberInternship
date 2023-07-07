package com.sbertech.task5;

import com.sbertech.Resource;

public class ResourceProcessor {

    private final Resource resource;

    public ResourceProcessor(Resource resource) {
        this.resource = resource;
    }

    public synchronized void increase() throws InterruptedException {
        while (resource.getCount() != 5) {
            wait();
        }

        resource.setCount(resource.getCount() + 1);
        System.out.println(resource.getCount());
        notify();
    }

    public synchronized void decrease() throws InterruptedException {
        while (resource.getCount() == 0) {
            wait();
        }

        resource.setCount(resource.getCount() - 1);
        System.out.println(resource.getCount());
        notify();
    }
}
