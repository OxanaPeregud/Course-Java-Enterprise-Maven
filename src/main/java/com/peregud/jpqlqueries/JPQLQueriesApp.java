package com.peregud.jpqlqueries;

import com.peregud.jpqlqueries.util.DBUtil;
import com.peregud.jpqlqueries.util.DataGeneratorUtil;
import com.peregud.jpqlqueries.util.HibernateUtil;

public class JPQLQueriesApp {
    public static void main(String[] args) {
        try {

            DataGeneratorUtil.generateDataForDB();
            DBUtil.selectAll("Salesperson").forEach(System.out::println);
            System.out.println(DBUtil.selectColumn("name", "Store"));
            System.out.println(DBUtil.selectColumn("lastName", "Salesperson"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
        }
    }
}
