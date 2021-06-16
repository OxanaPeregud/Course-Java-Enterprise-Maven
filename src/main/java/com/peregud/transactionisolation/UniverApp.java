package com.peregud.transactionisolation;

import com.peregud.transactionisolation.util.ConnectorUtil;
import com.peregud.transactionisolation.util.DataGeneratorUtil;
import com.peregud.transactionisolation.util.DataUtil;
import com.peregud.transactionisolation.util.HibernateUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class UniverApp {

    public static void main(String[] args) throws SQLException {
        try {

            DataUtil.saveData(DataGeneratorUtil.buildAdmin(100));
            DataUtil.saveData(DataGeneratorUtil.buildStudent(100));
            DataUtil.saveData(DataGeneratorUtil.buildCourse(100));
            DataUtil.saveData(DataGeneratorUtil.buildTeacher(100));
            DataUtil.saveData(DataGeneratorUtil.buildStudentResult(100));
            DataUtil.saveData(DataGeneratorUtil.buildTask(100));

            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

            executor.execute(() -> {
                long startTime = System.currentTimeMillis();
                DataUtil.updateData(DataGeneratorUtil.buildAdmin(100), Connection.TRANSACTION_READ_UNCOMMITTED);
                DataUtil.updateData(DataGeneratorUtil.buildStudent(100), Connection.TRANSACTION_READ_UNCOMMITTED);
                DataUtil.updateData(DataGeneratorUtil.buildCourse(100), Connection.TRANSACTION_READ_UNCOMMITTED);
                DataUtil.updateData(DataGeneratorUtil.buildTeacher(100), Connection.TRANSACTION_READ_UNCOMMITTED);
                DataUtil.updateData(DataGeneratorUtil.buildStudentResult(100), Connection.TRANSACTION_READ_UNCOMMITTED);
                DataUtil.updateData(DataGeneratorUtil.buildTask(100), Connection.TRANSACTION_READ_UNCOMMITTED);
                long endTime = System.currentTimeMillis();
                System.out.println("Read uncommitted: " + (endTime - startTime) + " milliseconds");
            });

            executor.execute(() -> {
                long startTime = System.currentTimeMillis();
                DataUtil.updateData(DataGeneratorUtil.buildAdmin(100), Connection.TRANSACTION_READ_COMMITTED);
                DataUtil.updateData(DataGeneratorUtil.buildStudent(100), Connection.TRANSACTION_READ_COMMITTED);
                DataUtil.updateData(DataGeneratorUtil.buildCourse(100), Connection.TRANSACTION_READ_COMMITTED);
                DataUtil.updateData(DataGeneratorUtil.buildTeacher(100), Connection.TRANSACTION_READ_COMMITTED);
                DataUtil.updateData(DataGeneratorUtil.buildStudentResult(100), Connection.TRANSACTION_READ_COMMITTED);
                DataUtil.updateData(DataGeneratorUtil.buildTask(100), Connection.TRANSACTION_READ_COMMITTED);
                long endTime = System.currentTimeMillis();
                System.out.println("Read committed: " + (endTime - startTime) + " milliseconds");
            });

            executor.execute(() -> {
                long startTime = System.currentTimeMillis();
                DataUtil.updateData(DataGeneratorUtil.buildAdmin(100), Connection.TRANSACTION_REPEATABLE_READ);
                DataUtil.updateData(DataGeneratorUtil.buildStudent(100), Connection.TRANSACTION_REPEATABLE_READ);
                DataUtil.updateData(DataGeneratorUtil.buildCourse(100), Connection.TRANSACTION_REPEATABLE_READ);
                DataUtil.updateData(DataGeneratorUtil.buildTeacher(100), Connection.TRANSACTION_REPEATABLE_READ);
                DataUtil.updateData(DataGeneratorUtil.buildStudentResult(100), Connection.TRANSACTION_REPEATABLE_READ);
                DataUtil.updateData(DataGeneratorUtil.buildTask(100), Connection.TRANSACTION_REPEATABLE_READ);
                long endTime = System.currentTimeMillis();
                System.out.println("Repeatable read: " + (endTime - startTime) + " milliseconds");
            });

            executor.execute(() -> {
                long startTime = System.currentTimeMillis();
                DataUtil.updateData(DataGeneratorUtil.buildAdmin(100), Connection.TRANSACTION_SERIALIZABLE);
                DataUtil.updateData(DataGeneratorUtil.buildStudent(100), Connection.TRANSACTION_SERIALIZABLE);
                DataUtil.updateData(DataGeneratorUtil.buildCourse(100), Connection.TRANSACTION_SERIALIZABLE);
                DataUtil.updateData(DataGeneratorUtil.buildTeacher(100), Connection.TRANSACTION_SERIALIZABLE);
                DataUtil.updateData(DataGeneratorUtil.buildStudentResult(100), Connection.TRANSACTION_SERIALIZABLE);
                DataUtil.updateData(DataGeneratorUtil.buildTask(100), Connection.TRANSACTION_SERIALIZABLE);
                long endTime = System.currentTimeMillis();
                System.out.println("Serializable: " + (endTime - startTime) + " milliseconds");
            });

            executor.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
            ConnectorUtil.closeConnection();
        }
    }
}
