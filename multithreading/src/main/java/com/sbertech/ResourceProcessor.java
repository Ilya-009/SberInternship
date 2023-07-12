package com.sbertech;

public class ResourceProcessor {

    private final Resource resource;

    public ResourceProcessor(Resource resource) {
        this.resource = resource;
    }

    public synchronized void increase() throws InterruptedException {
//        if (resource.getCount() >= 5) {
//            wait();
//        }

        resource.setCount(resource.getCount() + 1);
        System.out.println(resource.getCount());

//        notify();
    }

    public synchronized void decrease() throws InterruptedException {
//        while (resource.getCount() >= 1) {
//            wait();
//        }

        resource.setCount(resource.getCount() - 1);
        System.out.println(resource.getCount());

//        notify();
    }
}
