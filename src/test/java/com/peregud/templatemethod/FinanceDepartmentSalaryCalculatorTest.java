package com.peregud.templatemethod;

import org.junit.jupiter.api.Test;

import static com.peregud.templatemethod.SalaryType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FinanceDepartmentSalaryCalculatorTest {
    FinanceDepartmentSalaryCalculator financeDepartmentSalaryCalculator = new FinanceDepartmentSalaryCalculator();

    public void calculate() {
        financeDepartmentSalaryCalculator.calculateBasicSalary();
        financeDepartmentSalaryCalculator.calculateAdditionalSalary();
        financeDepartmentSalaryCalculator.calculateMonthlyBonus();
    }

    @Test
    void calculateBasicSalary() {
        calculate();
        assertEquals(10400.0, financeDepartmentSalaryCalculator.salary.get(BASIC_SALARY));
    }

    @Test
    void calculateAdditionalSalary() {
        calculate();
        assertEquals(3120.0, financeDepartmentSalaryCalculator.salary.get(ADDITIONAL_SALARY));
    }

    @Test
    void calculateMonthlyBonus() {
        calculate();
        assertEquals(2028.0, financeDepartmentSalaryCalculator.salary.get(MONTHLY_BONUS));
    }
}
