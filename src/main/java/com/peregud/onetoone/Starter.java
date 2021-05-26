package com.peregud.onetoone;

import javax.persistence.EntityManager;

public class Starter {
    public static void main(String[] args) {

        Employee employee = Employee.builder()
                .firstName("First Name")
                .lastName("Last Name")
                .build();

        EmployeeDetail employeeDetail = EmployeeDetail.builder()
                .street("Street")
                .city("City")
                .country("Country")
                .build();

        employee.setEmployeeDetail(employeeDetail);
        employeeDetail.setEmployee(employee);

        EntityManager entityManager = HibernateUtil.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        System.out.println(entityManager.find(Employee.class, employee.getEmployeeId()));
        System.out.println(entityManager.find(EmployeeDetail.class, employee.getEmployeeId()));
        HibernateUtil.close();
    }
}
