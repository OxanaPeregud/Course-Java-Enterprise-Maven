package com.peregud.commandpattern.client;

import com.peregud.commandpattern.invoker.DBControl;
import com.peregud.commandpattern.model.Employee;
import com.peregud.commandpattern.receiver.DB;
import com.peregud.commandpattern.util.HibernateUtil;

import java.sql.SQLException;

public class DBApplication {

    public static void main(String[] args) throws SQLException {

        Employee employee1 = Employee.builder()
                .firstName("First Name 1")
                .lastName("Last Name 1")
                .build();
        Employee employee2 = Employee.builder()
                .firstName("First Name 2")
                .lastName("Last Name 2")
                .build();

        DB<Employee> db = new DB<>();

        DBControl<Employee> dbControl = new DBControl<>(3);
        dbControl.setOperation(0, db::save);
        dbControl.setOperation(1, db::find);
        dbControl.setOperation(2, db::delete);

        dbControl.executeOperation(0, employee1, Employee.class, employee1.getEmployeeId());
        dbControl.executeOperation(0, employee2, Employee.class, employee1.getEmployeeId());
        dbControl.executeOperation(1, employee1, Employee.class, employee1.getEmployeeId());
        dbControl.executeOperation(2, employee2, Employee.class, employee2.getEmployeeId());

        HibernateUtil.close();
    }
}
