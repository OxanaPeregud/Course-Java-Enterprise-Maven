package com.peregud.templatemethod;

import com.peregud.templatemethod.util.DBUtil;

import static com.peregud.templatemethod.SalaryType.BASIC_SALARY;

public class SalesDepartmentSalaryCalculator extends SalaryCalculator {
    protected final int departmentId = 2;

    public SalesDepartmentSalaryCalculator() {
        additionalSalaryPercentage = 0.2;
        monthlyBonusPercentage = 0.1;
    }

    @Override
    public void calculateBasicSalary() {
        salary.put(BASIC_SALARY, DBUtil.salary(departmentId));
    }

    @Override
    public void calculateAdditionalSalary() {
        super.calculateAdditionalSalary();
    }

    @Override
    public void calculateMonthlyBonus() {
        super.calculateMonthlyBonus();
    }
}
