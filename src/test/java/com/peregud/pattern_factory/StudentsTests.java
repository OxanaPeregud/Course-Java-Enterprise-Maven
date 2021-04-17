package com.peregud.pattern_factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentsTests {
    StudentTypeOne studentTypeOne = new StudentTypeOne(0.1);
    StudentTypeTwo studentTypeTwo = new StudentTypeTwo(0.3);
    StudentTypeThree studentTypeThree = new StudentTypeThree(0.5);

    @Test
    public void getTalent_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(0.1, studentTypeOne.getTalent());
    }

    @Test
    public void getTheoryTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(220, studentTypeOne.getTheoryTime());
    }

    @Test
    public void getPracticeTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(220, studentTypeOne.getPracticeTime());
    }

    @Test
    public void getResearchTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(220, studentTypeOne.getResearchTime());
    }

    @Test
    public void getTotalTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(660, studentTypeOne.getTotalTime());
    }

    @Test
    public void getTalent_StudentTypeTwo() {
        studentTypeTwo.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(0.3, studentTypeTwo.getTalent());
    }

    @Test
    public void getTheoryTime_StudentTypeTwo() {
        studentTypeTwo.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(110, studentTypeTwo.getTheoryTime());
    }

    @Test
    public void getPracticeTime_StudentTypeTwo() {
        studentTypeTwo.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(110, studentTypeTwo.getPracticeTime());
    }

    @Test
    public void getResearchTime_StudentTypeTwo() {
        studentTypeTwo.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(0, studentTypeTwo.getResearchTime());
    }

    @Test
    public void getTotalTime_StudentTypeTwo() {
        studentTypeTwo.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(220, studentTypeTwo.getTotalTime());
    }

    @Test
    public void getTalent_StudentTypeThree() {
        studentTypeThree.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(0.5, studentTypeThree.getTalent());
    }

    @Test
    public void getTheoryTime_StudentTypeThree() {
        studentTypeThree.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(0, studentTypeThree.getTheoryTime());
    }

    @Test
    public void getPracticeTime_StudentTypeThree() {
        studentTypeThree.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(132, studentTypeThree.getPracticeTime());
    }

    @Test
    public void getResearchTime_StudentTypeThree() {
        studentTypeThree.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(0, studentTypeThree.getResearchTime());
    }

    @Test
    public void getTotalTime_StudentTypeThree() {
        studentTypeThree.masterSkill(PatternFactoryStarter.MASTER_JAVA_TIME);
        assertEquals(132, studentTypeThree.getTotalTime());
    }

    @Test
    public void createStudent_TypeOne_StudentFactory() {
        Study study = StudentFactory.createStudent(Student.TYPE_ONE);
        assertTrue(study instanceof StudentTypeOne);
    }

    @Test
    public void createStudent_TypeTwo_StudentFactory() {
        Study study = StudentFactory.createStudent(Student.TYPE_TWO);
        assertTrue(study instanceof StudentTypeTwo);
    }

    @Test
    public void createStudent_TypeThree_StudentFactory() {
        Study study = StudentFactory.createStudent(Student.TYPE_THREE);
        assertTrue(study instanceof StudentTypeThree);
    }
}
