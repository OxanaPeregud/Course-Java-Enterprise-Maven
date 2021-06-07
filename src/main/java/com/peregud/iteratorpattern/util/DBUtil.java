package com.peregud.iteratorpattern.util;

import com.peregud.iteratorpattern.ProductItem;
import lombok.experimental.UtilityClass;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class DBUtil {

    @SuppressWarnings("unchecked")
    public List<ProductItem> getProducts(String store) {
        List<ProductItem> productItemList = new ArrayList<>();
        List<Object[]> products;
        Transaction transaction = null;
        if (SessionUtil.getSessionFactory() != null) {
            try (Session session = SessionUtil.getSessionFactory().openSession()) {
                transaction = session.getTransaction();
                transaction.begin();
                Query query = session.createQuery("select id, name, price from " + store);
                products = query.getResultList();
                for (Object[] product : products) {
                    ProductItem productItem = new ProductItem();
                    Integer id = (Integer) product[0];
                    String name = (String) product[1];
                    Double price = (Double) product[2];
                    productItem.setId(id);
                    productItem.setName(name);
                    productItem.setPrice(price);
                    productItemList.add(productItem);
                }
                transaction.commit();
            } catch (HibernateException e) {
                e.printStackTrace();
                if (transaction != null)
                    transaction.rollback();
            }
        }
        return productItemList;
    }
}
