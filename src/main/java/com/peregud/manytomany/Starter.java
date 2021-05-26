package com.peregud.manytomany;

import javax.persistence.EntityManager;
import java.time.LocalDate;
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

        Meeting meeting = Meeting.builder()
                .subject("Subject")
                .startDate(LocalDate.now())
                .build();

        Set<Meeting> meetings = new HashSet<>();
        meetings.add(meeting);

        employee.setEmployeeDetail(employeeDetail);
        employee.setDepartment(department);
        employeeDetail.setEmployee(employee);
        department.setEmployees(employees);
        employee.setMeetings(meetings);
        meeting.setEmployees(employees);

        EntityManager entityManager = HibernateUtil.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        System.out.println(entityManager.find(Employee.class, employee.getEmployeeId()));
        System.out.println(entityManager.find(EmployeeDetail.class, employee.getEmployeeId()));
        System.out.println(entityManager.find(Department.class, employee.getEmployeeId()));
        System.out.println(entityManager.find(Meeting.class, employee.getEmployeeId()));
        HibernateUtil.close();
    }
}
