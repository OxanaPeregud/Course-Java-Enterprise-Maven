package com.peregud.patternstrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PatternStrategyStarter {
    public final static double MASTER_JAVA_TIME = 66;

    public static void start() {
        List<Student> studentList = Arrays.asList(
                new StudentTypeOne(TalentUtil.getTalent()),
                new StudentTypeOne(TalentUtil.getTalent()),
                new StudentTypeOne(TalentUtil.getTalent()),
                new StudentTypeTwo(TalentUtil.getTalent()),
                new StudentTypeTwo(TalentUtil.getTalent()),
                new StudentTypeTwo(TalentUtil.getTalent()),
                new StudentTypeThree(TalentUtil.getTalent()),
                new StudentTypeThree(TalentUtil.getTalent()),
                new StudentTypeThree(TalentUtil.getTalent())
        );
        List<Student> students = studentList.stream()
                .peek(Student -> Student.masterSkill(MASTER_JAVA_TIME))
                .collect(Collectors.toList());
        students.forEach(System.out::println);
    }
}
