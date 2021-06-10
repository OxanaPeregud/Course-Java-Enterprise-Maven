package com.peregud.jpqlqueries.util;

import com.peregud.jpqlqueries.model.FirstLastNames;
import com.peregud.jpqlqueries.model.LastNamesSalary;
import lombok.experimental.UtilityClass;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class DBUtil {

    public List<?> selectAll(String table) {
        return HibernateUtil.createEntityManager()
                .createQuery("SELECT s FROM " + table + " s")
                .getResultList();
    }

    public List<?> selectColumn(String field, String table) {
        return HibernateUtil.createEntityManager()
                .createQuery("SELECT s." + field + " FROM " + table + " s")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<?> selectSalesperson(double revenue) {
        List<FirstLastNames> firstLastNames = new ArrayList<>();
        List<Object[]> result;
        Query query = HibernateUtil.createEntityManager()
                .createQuery("SELECT s.firstName, s.lastName " +
                        "FROM Salesperson s WHERE s.store.revenue > :revenue")
                .setParameter("revenue", revenue);
        result = query.getResultList();
        for (Object[] salesperson : result) {
            FirstLastNames firstLastName = new FirstLastNames();
            String firstName = (String) salesperson[0];
            String lastName = (String) salesperson[1];
            firstLastName.setFirstName(firstName);
            firstLastName.setLastName(lastName);
            firstLastNames.add(firstLastName);
        }
        return firstLastNames;
    }

    @SuppressWarnings("unchecked")
    public List<?> selectSalesperson(LocalDate localDate) {
        List<LastNamesSalary> lastNamesSalaries = new ArrayList<>();
        List<Object[]> result;
        Query query = HibernateUtil.createEntityManager()
                .createQuery("SELECT s.lastName, s.salary " +
                        "FROM Salesperson s WHERE s.store.registrationDate < :localDate")
                .setParameter("localDate", localDate);
        result = query.getResultList();
        for (Object[] salesperson : result) {
            LastNamesSalary lastNamesSalary = new LastNamesSalary();
            String lastName = (String) salesperson[0];
            Double salary = (Double) salesperson[1];
            lastNamesSalary.setLastName(lastName);
            lastNamesSalary.setSalary(salary);
            lastNamesSalaries.add(lastNamesSalary);
        }
        return lastNamesSalaries;
    }

    public List<?> selectAllStores(String lastName1, String lastName2, String lastName3) {
        return HibernateUtil.createEntityManager()
                .createQuery("SELECT distinct s.store.name FROM Salesperson s WHERE s.lastName " +
                        "in (:lastName1, :lastName2, :lastName3)")
                .setParameter("lastName1", lastName1)
                .setParameter("lastName2", lastName2)
                .setParameter("lastName3", lastName3)
                .getResultList();
    }
}
