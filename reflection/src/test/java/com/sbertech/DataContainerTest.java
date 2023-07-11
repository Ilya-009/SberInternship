package com.sbertech;

import com.sbertech.annotated_classes.AnnotatedClassFirst;
import com.sbertech.annotated_classes.AnnotatedClassSecond;
import com.sbertech.annotations.InheritedAnnotation;
import com.sbertech.annotations.repeated_annotation.RepeatedAnnotation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class DataContainerTest {

    /**
     * Task 1
     */
    @Test
    void createDataContainerInstanceWithReflectionTest() {
        LocalDate firstClassDate = LocalDate.of(2023, 7, 15);
        LocalDate secondClassDate = LocalDate.of(2023, 7, 16);
        DataContainer dataContainer = new DataContainer(10, 1, "method 1");

        try {
            createInstances(firstClassDate, dataContainer);
            createInstances(secondClassDate, dataContainer);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    private void createInstances(LocalDate date, DataContainer dataContainer) throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        int day = date.getDayOfMonth();

        InheritedAnnotation firstClassAnnotation = AnnotatedClassFirst.class.getAnnotation(InheritedAnnotation.class);
        InheritedAnnotation secondClassAnnotation = AnnotatedClassSecond.class.getDeclaredAnnotation(InheritedAnnotation.class);

        Method dataContainerToStringMethod = dataContainer.getClass().getMethod("toString");

        if (firstClassAnnotation.dayNumber() == day) {
            Constructor<AnnotatedClassFirst> constructor = AnnotatedClassFirst.class.getConstructor();
            AnnotatedClassFirst annotatedClassFirst = constructor.newInstance();

            Assertions.assertNotNull(annotatedClassFirst);


            Method[] methods = AnnotatedClassFirst.class.getMethods();

            List<Method> filteredMethods = Arrays.stream(methods).filter(method -> {
                RepeatedAnnotation[] annotationsByType = method.getAnnotationsByType(RepeatedAnnotation.class);

                return Arrays.stream(annotationsByType)
                        .anyMatch(annotation ->
                                annotation.hour() == dataContainer.getHour() &&
                                        annotation.priority() == dataContainer.getPriority() &&
                                        annotation.description().contains(dataContainer.getDescription()));
            }).peek(method -> {
                try {
                    method.invoke(annotatedClassFirst, dataContainer);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }

                // Get changes in DataContainer
                try {
                    System.out.println(dataContainerToStringMethod.invoke(dataContainer));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }).toList();

            Assertions.assertTrue(filteredMethods.size() != 0);
            return;
        }

        if (secondClassAnnotation.dayNumber() == day) {
            // do stuff
            Constructor<AnnotatedClassSecond> constructor = AnnotatedClassSecond.class.getConstructor();
            AnnotatedClassSecond annotatedClassSecond = constructor.newInstance();

            Assertions.assertNotNull(annotatedClassSecond);
        }
    }
}