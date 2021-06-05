package com.peregud.templatemethod.util;

import lombok.experimental.UtilityClass;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@UtilityClass
public class DBUtil {
    private Session session;
    private Transaction transaction;

    public double salary(int departmentId) {
        double salary = 0;
        try {
            session = SessionUtil.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            salary = (double) session
                    .createQuery("SELECT SUM(salary) FROM employee WHERE department = " + departmentId)
                    .getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return salary;
    }
}
