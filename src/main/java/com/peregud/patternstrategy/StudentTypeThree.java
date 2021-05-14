package com.peregud.patternstrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StudentTypeThree extends StudentType {

    public StudentTypeThree(double talent) {
        super(talent);
    }

    public void masterSkill(double masterJavaTime) {
        double talent = getTalent();
        BigDecimal bigDecimal = BigDecimal.valueOf(PatternStrategyStarter.MASTER_JAVA_TIME / talent)
                .setScale(0, RoundingMode.HALF_UP);
        setPracticeTime(bigDecimal.doubleValue());
        setTotalTime(getPracticeTime());
    }

    public String toString() {
        return super.toString();
    }
}
