package com.peregud.reflection;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ReflectionUtilTests {

    @Test
    public void getAllMethods() {
        assertTrue(Arrays.toString(ReflectionUtil.getAllMethods(Man.class)).contains("getFirstName"));
        assertTrue(Arrays.toString(ReflectionUtil.getAllMethods(Man.class)).contains("getLastName"));
        assertTrue(Arrays.toString(ReflectionUtil.getAllMethods(Man.class)).contains("getAge"));
        assertFalse(Arrays.toString(ReflectionUtil.getAllMethods(Man.class)).contains("getBirthday"));
    }

    @Test
    public void getField() throws IllegalAccessException {
        Man man = new Man("Jeff", "Smith", 45);
        assertEquals("Jeff", ReflectionUtil.getField(Man.class, "firstName").get(man));
        assertEquals("Smith", ReflectionUtil.getField(Man.class, "lastName").get(man));
        assertEquals(45, ReflectionUtil.getField(Man.class, "age").get(man));
    }

    @Test
    public void getMethod() {
        Method method = ReflectionUtil.getMethod(Man.class, "getAge");
        assertEquals("int", method.getReturnType().toString());
    }
}