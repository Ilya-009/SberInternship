package com.sbertech;

public class ResourceProcessor {

    private final Resource resource;

    public ResourceProcessor(Resource resource) {
        this.resource = resource;
    }

    public synchronized void increase() {
        resource.setCount(resource.getCount() + 1);
    }

}
