package com.peregud.iteratorpattern.util;

import com.peregud.iteratorpattern.ProductItem;
import lombok.experimental.UtilityClass;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

@UtilityClass
public class DBUtil {
    private Session session;
    private Transaction transaction;

    public ProductItem getProducts(String store) {
        ProductItem productItem = new ProductItem();
        List<Object[]> products;
        try {
            session = SessionUtil.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            Query query = session.createQuery("select name, price from " + store);
            products = query.getResultList();
            for (Object[] product : products) {
                String name = (String) product[0];
                Double price = (Double) product[1];
                productItem.setName(name);
                productItem.setPrice(price);
                System.out.println(productItem);
            }
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return productItem;
    }
}
