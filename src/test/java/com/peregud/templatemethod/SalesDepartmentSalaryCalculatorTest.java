package com.peregud.templatemethod;

import org.junit.jupiter.api.Test;

import static com.peregud.templatemethod.SalaryType.BASIC_SALARY;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SalesDepartmentSalaryCalculatorTest {
    SalesDepartmentSalaryCalculator salesDepartmentSalaryCalculator = new SalesDepartmentSalaryCalculator();

    @Test
    void calculateBasicSalary() {
        salesDepartmentSalaryCalculator.calculateBasicSalary();
        assertEquals(7600.0, salesDepartmentSalaryCalculator.salary.get(BASIC_SALARY));
    }
}
