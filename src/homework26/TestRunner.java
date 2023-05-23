package homework26;

import homework26.annotation.AfterSuite;
import homework26.annotation.BeforeSuite;
import homework26.annotation.Test;
import homework26.exeption.TestClassException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {
    static void start(TestClass testClass) {
        List<Method> methods = Arrays.asList(testClass.getClass().getDeclaredMethods());

        if (methods.stream()
                .filter(m -> m.getAnnotation(BeforeSuite.class) != null)
                .count() > 1) {
            throw new TestClassException("In class must be no more than one @beforeSuite annotated method in class");
        } else if (methods.stream()
                .filter(m -> m.getAnnotation(AfterSuite.class) != null)
                .count() > 1) {
            throw new TestClassException("In class must be no more than one @afterSuite annotated method ");
        }

        methods.forEach(m -> {
                    if (m.isAnnotationPresent(BeforeSuite.class)) {
                        try {
                            m.invoke(testClass);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

        methods.stream()
                .filter(m -> m.getAnnotation(Test.class) != null)
                .sorted(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()))
                .forEach(m -> {
                    try {
                        m.invoke(testClass);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });

        methods.forEach(m -> {
                    if (m.isAnnotationPresent(AfterSuite.class)) {
                        try {
                            m.invoke(testClass);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

    }
}