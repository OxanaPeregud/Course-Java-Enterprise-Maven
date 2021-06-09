package com.peregud.jpqlqueries.util;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class DBUtil {

    public List<?> selectAll(String table) {
        return HibernateUtil.createEntityManager()
                .createQuery("SELECT e FROM " + table + " e")
                .getResultList();
    }

    public List<?> selectColumn(String field, String table) {
        return HibernateUtil.createEntityManager()
                .createQuery("SELECT e." + field + " FROM " + table + " e")
                .getResultList();
    }
}
