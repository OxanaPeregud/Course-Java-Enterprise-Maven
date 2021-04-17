package com.peregud.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {

    public static Method[] getAllMethods(Class<?> clazz) {
        Method[] methods = null;
        try {
            methods = clazz.getDeclaredMethods();
        } catch (SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return methods;
    }

    public static Field getField(Class<?> clazz, String fieldName) {
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return field;
    }

    public static Method getMethod(Class<?> clazz, String methodName) {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(methodName);
            method.setAccessible(true);
        } catch (SecurityException | IllegalArgumentException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }

    public static Object invokeMethod(Method method, Object object) {
        Object objectMethod = null;
        try {
            objectMethod = method.invoke(object);
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return objectMethod;
    }

    public static void checkIfAnnotated(Class<?> clazz, String methodName, Class<? extends Annotation> annotationClazz)
            throws AnnotationException, NoSuchMethodException {
        Method method = clazz.getMethod(methodName);
        if (!method.isAnnotationPresent(annotationClazz)) {
            throw new AnnotationException("The method " + method.getName() + " is not annotated with " +
                    annotationClazz.getName());
        } else {
            System.out.println("The method " + method.getName() + " is annotated with " + annotationClazz.getName());
        }
    }
}
