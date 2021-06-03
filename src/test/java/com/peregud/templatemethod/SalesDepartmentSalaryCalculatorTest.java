package com.peregud.templatemethod;

import org.junit.jupiter.api.Test;

import static com.peregud.templatemethod.SalaryType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SalesDepartmentSalaryCalculatorTest {
    SalesDepartmentSalaryCalculator salesDepartmentSalaryCalculator = new SalesDepartmentSalaryCalculator();

    public void calculate() {
        salesDepartmentSalaryCalculator.calculateBasicSalary();
        salesDepartmentSalaryCalculator.calculateAdditionalSalary();
        salesDepartmentSalaryCalculator.calculateMonthlyBonus();
    }

    @Test
    void calculateBasicSalary() {
        calculate();
        assertEquals(7600.0, salesDepartmentSalaryCalculator.salary.get(BASIC_SALARY));
    }

    @Test
    void calculateAdditionalSalary() {
        calculate();
        assertEquals(1520.0, salesDepartmentSalaryCalculator.salary.get(ADDITIONAL_SALARY));
    }

    @Test
    void calculateMonthlyBonus() {
        calculate();
        assertEquals(912.0, salesDepartmentSalaryCalculator.salary.get(MONTHLY_BONUS));
    }
}
