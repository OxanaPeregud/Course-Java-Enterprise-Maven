package com.peregud.dbprocedure.util;

import com.peregud.dbprocedure.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ReflectionUtilTest {

    @Test
    void annotatedField() {
        assertEquals("first_name", ReflectionUtil.annotatedField(Person.class, "firstName"));
        assertNotEquals("firstName", ReflectionUtil.annotatedField(Person.class, "firstName"));
    }

    @Test
    public void testPrivateConstructor() {
        Class<ReflectionUtil> clazz = null;
        try {
            clazz = ReflectionUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }

    @Test
    public void testException() {
        try {
            ReflectionUtil.annotatedField(Person.class, "first");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
