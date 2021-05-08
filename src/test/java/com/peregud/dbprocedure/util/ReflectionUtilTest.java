package com.peregud.dbprocedure.util;

import com.peregud.dbprocedure.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilTest {

    @Test
    void annotatedField() {
        assertEquals("first_name", ReflectionUtil.annotatedField(Person.class, "firstName"));
        assertNotEquals("firstName", ReflectionUtil.annotatedField(Person.class, "firstName"));
    }
}
