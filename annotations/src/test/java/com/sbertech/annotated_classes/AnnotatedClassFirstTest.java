package com.sbertech.annotated_classes;

import com.sbertech.DataContainer;
import com.sbertech.annotations.InheritedAnnotation;
import com.sbertech.annotations.RepeatedAnnotation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

class AnnotatedClassFirstTest {

    static AnnotatedClassFirst annotatedClassFirst;

    @BeforeAll
    static void beforeAll() {
        annotatedClassFirst = new AnnotatedClassFirst();
    }

    @Test
    void testAnnotationInheritance() {
        InheritedAnnotation baseClassAnnotations = AnnotatedClassBase.class.getAnnotation(InheritedAnnotation.class);
        InheritedAnnotation firstClassAnnotations = AnnotatedClassFirst.class.getAnnotation(InheritedAnnotation.class);
        InheritedAnnotation secondClassAnnotations = AnnotatedClassSecond.class.getAnnotation(InheritedAnnotation.class);

        Assertions.assertEquals(baseClassAnnotations.dayNumber(), firstClassAnnotations.dayNumber());
        Assertions.assertEquals(baseClassAnnotations.dayNumber(), 15);

        Assertions.assertNotEquals(baseClassAnnotations.dayNumber(), secondClassAnnotations.dayNumber());
    }

    @Test
    void doStuff1() throws NoSuchMethodException {
        Method method = AnnotatedClassFirst.class.getMethod("doStuff1", DataContainer.class);
        RepeatedAnnotation annotation = method.getAnnotation(RepeatedAnnotation.class);

        Assertions.assertThrows(NullPointerException.class, () -> annotatedClassFirst.doStuff1(null));
        Assertions.assertEquals(annotation.hour(), 10);
        Assertions.assertEquals(annotation.priority(), 1);
        Assertions.assertEquals(annotation.description(), "method 1");
    }

    @Test
    void doStuff2() throws NoSuchMethodException {
        Method method = AnnotatedClassFirst.class.getMethod("doStuff1", DataContainer.class);
        RepeatedAnnotation annotation = method.getAnnotation(RepeatedAnnotation.class);

        Assertions.assertThrows(NullPointerException.class, () -> annotatedClassFirst.doStuff2(null));
        Assertions.assertEquals(annotation.hour(), 10);
        Assertions.assertEquals(annotation.priority(), 1);
        Assertions.assertEquals(annotation.description(), "method 1");
    }
}