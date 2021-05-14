package com.peregud.dbprocedure.util;

import com.peregud.dbprocedure.model.FieldName;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public class ReflectionUtil {

    public String annotatedField(Class<?> clazz, String fieldName) {
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
