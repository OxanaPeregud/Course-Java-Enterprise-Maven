package com.peregud.decoratorpattern.util;

import lombok.experimental.UtilityClass;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

@UtilityClass
public class PizzaDBUtil {

    public double getPizzaCost(String pizzaName) {
        SessionUtil util = new SessionUtil();
        Session session = util.openSession();
        Transaction transaction = session.getTransaction();
        double result = 0;
        try {
            transaction.begin();
            String hql = "SELECT pizzaCost FROM pizza WHERE pizzaName LIKE " + pizzaName;
            Query query = session.createQuery(hql);
            result = (double) query.getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            util.closeSession();
        }
        return result;
    }

    public double getIngredientCost(String ingredientName) {
        SessionUtil util = new SessionUtil();
        Session session = util.openSession();
        Transaction transaction = session.getTransaction();
        double result = 0;
        try {
            transaction.begin();
            String hql = "SELECT ingredientCost FROM ingredient WHERE ingredientName LIKE " + ingredientName;
            Query query = session.createQuery(hql);
            result = (double) query.getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            util.closeSession();
        }
        return result;
    }
}
