package com.peregud.templatemethod;

import com.peregud.templatemethod.util.DBUtil;

import static com.peregud.templatemethod.SalaryType.*;

public class FinanceDepartmentSalaryCalculator extends SalaryCalculator {

    @Override
    public void calculateBasicSalary() {
        salary.put(BASIC_SALARY, DBUtil.salary(1));
    }

    @Override
    public void calculateAdditionalSalary() {
        setAdditionalSalaryPercentage(0.3);
        super.calculateAdditionalSalary();
    }

    @Override
    public void calculateMonthlyBonus() {
        setMonthlyBonusPercentage(0.15);
        super.calculateMonthlyBonus();
    }
}
