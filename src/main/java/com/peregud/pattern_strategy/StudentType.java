package com.peregud.pattern_strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StudentType implements Student {
    private double talent;
    private double theoryTime;
    private double practiceTime;
    private double researchTime;
    private double totalTime;

    public StudentType(double talent) {
        this.talent = talent;
    }

    public void masterSkill(double masterJavaTime) {
        theoryTime = practiceTime = researchTime = BigDecimal.valueOf((
                PatternStrategyStarter.MASTER_JAVA_TIME / 3) / getTalent())
                .setScale(0, RoundingMode.HALF_UP).doubleValue();
        totalTime = theoryTime + practiceTime + researchTime;
    }

    public double getTalent() {
        return talent;
    }

    public void setTalent(double talent) {
        this.talent = talent;
    }

    public double getTheoryTime() {
        return theoryTime;
    }

    public void setTheoryTime(double theoryTime) {
        this.theoryTime = theoryTime;
    }

    public double getPracticeTime() {
        return practiceTime;
    }

    public void setPracticeTime(double practiceTime) {
        this.practiceTime = practiceTime;
    }

    public double getResearchTime() {
        return researchTime;
    }

    public void setResearchTime(double researchTime) {
        this.researchTime = researchTime;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public String toString() {
        return "talent=" + talent +
                ", theoryTime=" + theoryTime +
                ", practiceTime=" + practiceTime +
                ", researchTime=" + researchTime +
                ", totalTime=" + totalTime +
                '}';
    }
}
