package com.peregud.templatemethod;

import com.peregud.templatemethod.util.SessionUtil;

public class SalaryApplication {

    public static void main(String[] args) {

        SalaryCalculator salaryCalculator1 = new SalesDepartmentSalaryCalculator();
        Salary salary1 = salaryCalculator1.calculateSalary();
        System.out.println("Sales Department Salary:");
        salary1.getSalary().forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println(salary1.totalSalary());

        SalaryCalculator salaryCalculator2 = new FinanceDepartmentSalaryCalculator();
        Salary salary2 = salaryCalculator2.calculateSalary();
        System.out.println("Finance Department Salary:");
        salary2.getSalary().forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println(salary2.totalSalary());

        SessionUtil.closeSession();
    }
}
