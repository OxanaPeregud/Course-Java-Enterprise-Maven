package com.peregud.daoutil.util;

import com.peregud.daoutil.model.FieldName;

import java.lang.reflect.Field;

public class ReflectionUtil {

    public static String annotatedField(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            if (field.isAnnotationPresent(FieldName.class)) {
                fieldName = field.getAnnotation(FieldName.class).key();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return fieldName;
    }
}
