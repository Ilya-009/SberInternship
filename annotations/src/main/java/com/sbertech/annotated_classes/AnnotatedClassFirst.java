package com.sbertech.annotated_classes;

import com.sbertech.DataContainer;
import com.sbertech.annotations.RepeatedAnnotation;
import lombok.NonNull;

public class AnnotatedClassFirst extends AnnotatedClassBase {
    @RepeatedAnnotation(hour = 10, priority = 1, description = "method 1")
    public void doStuff1(@NonNull DataContainer arg1) {
        // Do stuff
    }

    @RepeatedAnnotation(hour = 15, priority = 2, description = "method 2")
    public void doStuff2(@NonNull DataContainer arg2) {
        // Do stuff
    }
}
