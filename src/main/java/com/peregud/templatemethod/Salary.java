package com.peregud.templatemethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class Salary {
    private final Map<SalaryType, Double> salary;

    public double totalSalary() {
        return salary
                .values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .reduce(0, Double::sum);
    }
}
