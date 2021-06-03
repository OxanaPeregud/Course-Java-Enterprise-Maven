package com.peregud.templatemethod;

import org.junit.jupiter.api.Test;

import static com.peregud.templatemethod.SalaryType.BASIC_SALARY;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FinanceDepartmentSalaryCalculatorTest {
    FinanceDepartmentSalaryCalculator financeDepartmentSalaryCalculator = new FinanceDepartmentSalaryCalculator();

    @Test
    void calculateBasicSalary() {
        financeDepartmentSalaryCalculator.calculateBasicSalary();
        assertEquals(10400.0, financeDepartmentSalaryCalculator.salary.get(BASIC_SALARY));
    }
}
