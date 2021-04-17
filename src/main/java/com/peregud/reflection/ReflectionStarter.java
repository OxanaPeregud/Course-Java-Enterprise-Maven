package com.peregud.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionStarter {

    public static void start() throws IllegalAccessException, AnnotationException, NoSuchMethodException {
        Man man = new Man("Jeff", "Smith", 45);
        Arrays.stream(ReflectionUtil.getAllMethods(Man.class)).forEach(System.out::println);
        System.out.println((ReflectionUtil.getField(Man.class, "firstName").get(man)));
        System.out.println((ReflectionUtil.getField(Man.class, "lastName").get(man)));
        System.out.println((ReflectionUtil.getField(Man.class, "age").get(man)));
        Method method = ReflectionUtil.getMethod(HelloWorld.class, "printHelloWorld");
        System.out.println((ReflectionUtil.invokeMethod(method, HelloWorld.class)));
        ReflectionUtil.checkIfAnnotated(Academy.class, "displayCurrentYear", AcademyInfo.class);
        ReflectionUtil.checkIfAnnotated(Academy.class, "displayYear", AcademyInfo.class);
    }
}
