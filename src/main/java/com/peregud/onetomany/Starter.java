package com.peregud.onetomany;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class Starter {
    public static void main(String[] args) {

        EmployeeDetail employeeDetail = EmployeeDetail.builder()
                .street("Street")
                .city("City")
                .country("Country")
                .build();

        Department department = Department.builder()
                .name("Department")
                .build();

        Employee employee = Employee.builder()
                .firstName("First Name")
                .lastName("Last Name")
                .employeeDetail(employeeDetail)
                .department(department)
                .build();

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);

        employee.setEmployeeDetail(employeeDetail);
        employee.setDepartment(department);
        employeeDetail.setEmployee(employee);
        department.setEmployees(employees);

        EntityManager entityManager = HibernateUtil.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        System.out.println(entityManager.find(Employee.class, employee.getEmployeeId()));
        System.out.println(entityManager.find(EmployeeDetail.class, employee.getEmployeeId()));
        System.out.println(entityManager.find(Department.class, employee.getEmployeeId()));
        HibernateUtil.close();
    }
}
