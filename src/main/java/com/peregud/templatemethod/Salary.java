package com.peregud.templatemethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class Salary {
    private final Map<SalaryType, Double> salary;
}
