package com.peregud.jpqlqueries.util;

import com.peregud.jpqlqueries.model.FirstLastNames;
import com.peregud.jpqlqueries.model.LastNamesSalary;
import lombok.experimental.UtilityClass;
import org.hibernate.transform.ResultTransformer;

import java.time.LocalDate;
import java.util.List;

@UtilityClass
public class DBUtil {

    public List<?> selectAll(String table) {
        return HibernateUtil.createEntityManager()
                .createQuery("FROM " + table)
                .getResultList();
    }

    public List<?> selectColumn(String field, String table) {
        return HibernateUtil.createEntityManager()
                .createQuery("SELECT " + field + " FROM " + table)
                .getResultList();
    }

    public List<?> selectSalesperson(double revenue) {
        return (List<?>)
                HibernateUtil.createEntityManager()
                        .createQuery(
                                "SELECT firstName, lastName FROM Salesperson WHERE store.revenue > :revenue")
                        .setParameter("revenue", revenue)
                        .unwrap(org.hibernate.query.Query.class)
                        .setResultTransformer(
                                new ResultTransformer() {
                                    @Override
                                    public Object transformTuple(Object[] tuples, String[] aliases) {
                                        FirstLastNames firstLastNames = new FirstLastNames();
                                        firstLastNames.setFirstName((String) tuples[0]);
                                        firstLastNames.setLastName((String) tuples[1]);
                                        return firstLastNames;
                                    }

                                    @Override
                                    public List<?> transformList(List tuples) {
                                        return tuples;
                                    }
                                }
                        )
                        .getResultList();
    }


    public List<?> selectSalesperson(LocalDate localDate) {
        return (List<?>)
                HibernateUtil.createEntityManager()
                        .createQuery(
                                "SELECT lastName, salary FROM Salesperson WHERE store.registrationDate < :localDate")
                        .setParameter("localDate", localDate)
                        .unwrap(org.hibernate.query.Query.class)
                        .setResultTransformer(
                                new ResultTransformer() {
                                    @Override
                                    public Object transformTuple(Object[] tuples, String[] aliases) {
                                        LastNamesSalary lastNamesSalary = new LastNamesSalary();
                                        lastNamesSalary.setLastName((String) tuples[0]);
                                        lastNamesSalary.setSalary((Double) tuples[1]);
                                        return lastNamesSalary;
                                    }

                                    @Override
                                    public List<?> transformList(List tuples) {
                                        return tuples;
                                    }
                                }
                        )
                        .getResultList();
    }

    public List<?> selectAllStores(List<String> lastName) {
        return HibernateUtil.createEntityManager()
                .createQuery("SELECT distinct store.name FROM Salesperson WHERE lastName in (:lastName)")
                .setParameter("lastName", lastName)
                .getResultList();
    }
}
