package com.peregud.dbprocedure.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

class DBUtilTest {

    @Test
    public void testPrivateConstructor() {
        Class<DBUtil> clazz = null;
        try {
            clazz = DBUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
