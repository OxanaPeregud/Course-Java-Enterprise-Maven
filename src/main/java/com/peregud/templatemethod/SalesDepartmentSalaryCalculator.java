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
        double additionalSalary = salary.get(BASIC_SALARY) * 0.2;
        salary.put(ADDITIONAL_SALARY, additionalSalary);
    }

    @Override
    public void calculateMonthlyBonus() {
        double monthlyBonus = (salary.get(BASIC_SALARY) + salary.get(ADDITIONAL_SALARY)) * 0.1;
        salary.put(MONTHLY_BONUS, monthlyBonus);
    }
}
