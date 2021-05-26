package com.peregud.commandpattern.client;

import com.peregud.commandpattern.command.DeleteDBOperation;
import com.peregud.commandpattern.command.FindDBOperation;
import com.peregud.commandpattern.command.SaveDBOperation;
import com.peregud.commandpattern.command.DBOperation;
import com.peregud.commandpattern.invoker.DBOperationExecutor;
import com.peregud.commandpattern.model.Employee;
import com.peregud.commandpattern.receiver.DB;
import com.peregud.commandpattern.util.HibernateUtil;

import java.sql.SQLException;

public class DBApplication {

    public static void main(String[] args) throws SQLException {

        Employee employee = Employee.builder()
                .firstName("First Name")
                .lastName("Last Name")
                .build();

        DBOperation<Employee> saveDBOperation = new SaveDBOperation<>(new DB<>());
        DBOperation<Employee> findDBOperation = new FindDBOperation<>(new DB<>());
        DBOperation<Employee> deleteDBOperation = new DeleteDBOperation<>(new DB<>());
        DBOperationExecutor<Employee> DBOperationExecutor = new DBOperationExecutor<>();

        System.out.println(DBOperationExecutor.executeOperation(saveDBOperation, employee, Employee.class,
                employee.getEmployeeId()));
        System.out.println(DBOperationExecutor.executeOperation(findDBOperation, employee, Employee.class,
                employee.getEmployeeId()));
        System.out.println(DBOperationExecutor.executeOperation(deleteDBOperation, employee, Employee.class,
                employee.getEmployeeId()));
        HibernateUtil.close();
    }
}
