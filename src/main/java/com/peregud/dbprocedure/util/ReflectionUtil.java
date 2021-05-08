package com.peregud.dbprocedure.util;

import com.peregud.dbprocedure.model.FieldName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.lang.reflect.Field;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
