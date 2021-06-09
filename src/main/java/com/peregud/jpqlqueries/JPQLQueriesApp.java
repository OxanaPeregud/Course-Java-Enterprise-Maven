package com.peregud.jpqlqueries;

import com.peregud.jpqlqueries.util.DBUtil;
import com.peregud.jpqlqueries.util.DataGeneratorUtil;
import com.peregud.jpqlqueries.util.HibernateUtil;

import java.time.LocalDate;
import java.util.List;

public class JPQLQueriesApp {
    public static void main(String[] args) {
        try {

            DataGeneratorUtil.generateDataForDB();
            DBUtil.selectAll("Salesperson").forEach(System.out::println);
            System.out.println(DBUtil.selectColumn("name", "Store"));
            System.out.println(DBUtil.selectColumn("lastName", "Salesperson"));
            System.out.println(DBUtil.selectSalesperson(1000));
            System.out.println(DBUtil.selectSalesperson(LocalDate.of(2010, 6, 6)));
            System.out.println(DBUtil.selectAllStores(List.of("Иванов", "Петров", "Сидоров")));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
        }
    }
}
