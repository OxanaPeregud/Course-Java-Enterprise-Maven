package com.peregud.observerpattern;

import com.peregud.observerpattern.util.SessionUtil;
import lombok.Getter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.time.LocalDateTime;

public class MeetupDB {
    @Getter
    private static final SessionUtil UTIL = new SessionUtil();
    private final Session session = UTIL.openSession();
    private final Transaction transaction = session.getTransaction();

    public LocalDateTime getMeetupTime(int id) {
        LocalDateTime result = null;
        try {
            transaction.begin();
            String hql = "SELECT meetupTime FROM meetup WHERE meetupId = " + id;
            Query query = session.createQuery(hql);
            result = (LocalDateTime) query.getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public String getLocation(int id) {
        String result = null;
        try {
            transaction.begin();
            String hql = "SELECT location FROM meetup WHERE meetupId = " + id;
            Query query = session.createQuery(hql);
            result = (String) query.getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public String getTopic(int id) {
        String result = null;
        try {
            transaction.begin();
            String hql = "SELECT topic FROM meetup WHERE meetupId = " + id;
            Query query = session.createQuery(hql);
            result = (String) query.getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
