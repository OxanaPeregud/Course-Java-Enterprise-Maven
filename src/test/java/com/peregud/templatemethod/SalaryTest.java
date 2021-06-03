package com.peregud.templatemethod;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.peregud.templatemethod.SalaryType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SalaryTest {

    public Salary salary() {
        Map<SalaryType, Double> map = new HashMap<>();
        map.put(BASIC_SALARY, 1000.0);
        map.put(ADDITIONAL_SALARY, 500.0);
        map.put(MONTHLY_BONUS, 100.0);
        map.put(YEAR_END_BONUS, 1000.0);
        return new Salary(map);
    }

    @Test
    void totalSalary() {
        assertEquals(2600.0, salary().totalSalary());
    }
}
