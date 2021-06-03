package com.peregud.templatemethod;

import com.peregud.templatemethod.util.DBUtil;

import static com.peregud.templatemethod.SalaryType.*;

public class SalesDepartmentSalaryCalculator extends SalaryCalculator {

    @Override
    public void calculateBasicSalary() {
        salary.put(BASIC_SALARY, DBUtil.salary(2));
    }

    @Override
    public void calculateAdditionalSalary() {
        setAdditionalSalaryPercentage(0.2);
        super.calculateAdditionalSalary();
    }

    @Override
    public void calculateMonthlyBonus() {
        setMonthlyBonusPercentage(0.1);
        super.calculateMonthlyBonus();
    }
}
