package com.peregud.templatemethod;

import com.peregud.templatemethod.util.DBUtil;

import static com.peregud.templatemethod.SalaryType.*;

public class FinanceDepartmentSalaryCalculator extends SalaryCalculator {
    protected final int departmentId = 1;

    public FinanceDepartmentSalaryCalculator() {
        additionalSalaryPercentage = 0.3;
        monthlyBonusPercentage = 0.15;
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
