package com.peregud.patternfactory;

public class StudentFactory {

    public static Study createStudent(Student student) {
        Study study = null;
        switch (student) {
            case TYPE_ONE:
                study = new StudentTypeOne(TalentUtil.getTalent());
                break;
            case TYPE_TWO:
                study = new StudentTypeTwo(TalentUtil.getTalent());
                break;
            case TYPE_THREE:
                study = new StudentTypeThree(TalentUtil.getTalent());
                break;
        }
        return study;
    }
}
