package com.peregud.patternfactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StudentTypeTwo extends StudentType {

    public StudentTypeTwo(double talent) {
        super(talent);
    }

    public void masterSkill(double masterJavaTime) {
        double talent = getTalent();
        BigDecimal bigDecimal = BigDecimal.valueOf((PatternFactoryStarter.MASTER_JAVA_TIME / 2) / talent)
                .setScale(0, RoundingMode.HALF_UP);
        setTheoryTime(bigDecimal.doubleValue());
        setPracticeTime(bigDecimal.doubleValue());
        setTotalTime(getPracticeTime() + getTheoryTime());
    }

    public String toString() {
        return super.toString();
    }
}
