package com.peregud.pattern_factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PatternFactoryStarter {
    public static final double MASTER_JAVA_TIME = 66;

    public static void start() {
        List<Study> studyList = Arrays.asList(
                StudentFactory.createStudent(Student.TYPE_ONE),
                StudentFactory.createStudent(Student.TYPE_ONE),
                StudentFactory.createStudent(Student.TYPE_ONE),
                StudentFactory.createStudent(Student.TYPE_TWO),
                StudentFactory.createStudent(Student.TYPE_TWO),
                StudentFactory.createStudent(Student.TYPE_TWO),
                StudentFactory.createStudent(Student.TYPE_THREE),
                StudentFactory.createStudent(Student.TYPE_THREE),
                StudentFactory.createStudent(Student.TYPE_THREE)
        );
        List<Study> studies = studyList.stream()
                .peek(Study -> Study.masterSkill(MASTER_JAVA_TIME))
                .collect(Collectors.toList());
        studies.forEach(System.out::println);
    }
}
