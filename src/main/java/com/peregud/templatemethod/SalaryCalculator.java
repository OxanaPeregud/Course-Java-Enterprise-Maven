package com.peregud.templatemethod;

import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.peregud.templatemethod.SalaryType.*;

@Setter
public abstract class SalaryCalculator {
    protected Map<SalaryType, Double> salary = new LinkedHashMap<>();
    protected double additionalSalaryPercentage;
    protected double monthlyBonusPercentage;

    public final Salary calculateSalary() {
        calculateBasicSalary();
        calculateAdditionalSalary();
        calculateMonthlyBonus();
        calculateYearEndBonus(1000.0);
        return getSalary();
    }

    public abstract void calculateBasicSalary();

    public void calculateAdditionalSalary() {
        double additionalSalary = salary.get(BASIC_SALARY) * additionalSalaryPercentage;
        salary.put(ADDITIONAL_SALARY, additionalSalary);
    }

    public void calculateMonthlyBonus() {
        double monthlyBonus = (salary.get(BASIC_SALARY) + salary.get(ADDITIONAL_SALARY)) * monthlyBonusPercentage;
        salary.put(MONTHLY_BONUS, monthlyBonus);
    }

    public void calculateYearEndBonus(double yearEndBonus) {
        salary.put(YEAR_END_BONUS, yearEndBonus);
    }

    private Salary getSalary() {
        return new Salary(salary);
    }
}
