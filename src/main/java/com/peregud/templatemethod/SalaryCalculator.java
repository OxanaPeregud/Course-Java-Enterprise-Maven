package com.peregud.templatemethod;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.peregud.templatemethod.SalaryType.YEAR_END_BONUS;

@Getter
public abstract class SalaryCalculator {
    protected Map<SalaryType, Double> salary = new LinkedHashMap<>();

    public final Salary calculateSalary() {
        calculateBasicSalary();
        calculateAdditionalSalary();
        calculateMonthlyBonus();
        calculateYearEndBonus();
        return getSalary();
    }

    public abstract void calculateBasicSalary();

    public abstract void calculateAdditionalSalary();

    public abstract void calculateMonthlyBonus();

    public void calculateYearEndBonus() {
        salary.put(YEAR_END_BONUS, 1000.0);
    }

    private Salary getSalary() {
        return new Salary(salary);
    }

    public double totalSalary() {
        return salary
                .values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .reduce(0, Double::sum);
    }
}
