package com.peregud.templatemethod.util;

import lombok.experimental.UtilityClass;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@UtilityClass
public class DBUtil {

    public Double salary(int departmentId) {
        Session session = SessionUtil.openSession();
        Transaction transaction = session.getTransaction();
        Double salary = null;
        try {
            transaction.begin();
            salary = (Double) session
                    .createQuery("SELECT SUM(salary) FROM employee WHERE department = " + departmentId)
                    .getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            SessionUtil.closeSession();
        }
        return salary;
    }
}
