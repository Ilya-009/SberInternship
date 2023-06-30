package com.sbertech.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(RepeatedAnnotationContainer.class)
public @interface RepeatedAnnotation {
    int hour() default 0;
    int priority() default 0;
    String description() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RepeatedAnnotationContainer {
    RepeatedAnnotation[] value();
}
