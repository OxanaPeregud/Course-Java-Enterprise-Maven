package com.peregud.reflection;

public class Academy {
    public int year;

    @AcademyInfo(year = 2021)
    public int displayCurrentYear() {
        return year;
    }

    public int displayYear() {
        return year;
    }
}
