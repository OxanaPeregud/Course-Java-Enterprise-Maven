package com.peregud.decoratorpattern.util;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

@UtilityClass
public class PizzaDBUtil {
    @Getter
    private final SessionUtil UTIL = new SessionUtil();
    private final Session SESSION = UTIL.openSession();
    private final Transaction TRANSACTION = SESSION.getTransaction();

    public double getPizzaCost(String pizzaName) {
        double result = 0;
        try {
            TRANSACTION.begin();
            String hql = "SELECT pizzaCost FROM pizza WHERE pizzaName LIKE " + pizzaName;
            Query query = SESSION.createQuery(hql);
            result = (double) query.getSingleResult();
            TRANSACTION.commit();
        } catch (HibernateException e) {
            TRANSACTION.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public double getIngredientCost(String ingredientName) {
        double result = 0;
        try {
            TRANSACTION.begin();
            String hql = "SELECT ingredientCost FROM ingredient WHERE ingredientName LIKE " + ingredientName;
            Query query = SESSION.createQuery(hql);
            result = (double) query.getSingleResult();
            TRANSACTION.commit();
        } catch (HibernateException e) {
            TRANSACTION.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
