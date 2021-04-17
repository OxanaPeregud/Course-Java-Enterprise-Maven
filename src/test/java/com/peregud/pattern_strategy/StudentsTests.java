package com.peregud.pattern_strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentsTests {
    StudentTypeOne studentTypeOne = new StudentTypeOne(0.1);
    StudentTypeTwo studentTypeTwo = new StudentTypeTwo(0.3);
    StudentTypeThree studentTypeThree = new StudentTypeThree(0.5);

    @Test
    public void getTalent_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(0.1, studentTypeOne.getTalent());
    }

    @Test
    public void setTalent_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        studentTypeOne.setTalent(0.5);
        assertEquals(0.5, studentTypeOne.getTalent());
    }

    @Test
    public void getTheoryTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(220, studentTypeOne.getTheoryTime());
    }

    @Test
    public void setTheoryTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        studentTypeOne.setTheoryTime(180);
        assertEquals(180, studentTypeOne.getTheoryTime());
    }

    @Test
    public void getPracticeTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(220, studentTypeOne.getPracticeTime());
    }

    @Test
    public void setPracticeTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        studentTypeOne.setPracticeTime(250);
        assertEquals(250, studentTypeOne.getPracticeTime());
    }

    @Test
    public void getResearchTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(220, studentTypeOne.getResearchTime());
    }

    @Test
    public void setResearchTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        studentTypeOne.setResearchTime(100);
        assertEquals(100, studentTypeOne.getResearchTime());
    }

    @Test
    public void getTotalTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(660, studentTypeOne.getTotalTime());
    }

    @Test
    public void setTotalTime_StudentTypeOne() {
        studentTypeOne.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        studentTypeOne.setTotalTime(700);
        assertEquals(700, studentTypeOne.getTotalTime());
    }

    @Test
    public void getTalent_StudentTypeTwo() {
        studentTypeTwo.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(0.3, studentTypeTwo.getTalent());
    }

    @Test
    public void getTheoryTime_StudentTypeTwo() {
        studentTypeTwo.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(110, studentTypeTwo.getTheoryTime());
    }

    @Test
    public void getPracticeTime_StudentTypeTwo() {
        studentTypeTwo.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(110, studentTypeTwo.getPracticeTime());
    }

    @Test
    public void getResearchTime_StudentTypeTwo() {
        studentTypeTwo.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(0, studentTypeTwo.getResearchTime());
    }

    @Test
    public void getTotalTime_StudentTypeTwo() {
        studentTypeTwo.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(220, studentTypeTwo.getTotalTime());
    }

    @Test
    public void getTalent_StudentTypeThree() {
        studentTypeThree.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(0.5, studentTypeThree.getTalent());
    }

    @Test
    public void getTheoryTime_StudentTypeThree() {
        studentTypeThree.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(0, studentTypeThree.getTheoryTime());
    }

    @Test
    public void getPracticeTime_StudentTypeThree() {
        studentTypeThree.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(132, studentTypeThree.getPracticeTime());
    }

    @Test
    public void getResearchTime_StudentTypeThree() {
        studentTypeThree.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(0, studentTypeThree.getResearchTime());
    }

    @Test
    public void getTotalTime_StudentTypeThree() {
        studentTypeThree.masterSkill(PatternStrategyStarter.MASTER_JAVA_TIME);
        assertEquals(132, studentTypeThree.getTotalTime());
    }
}
