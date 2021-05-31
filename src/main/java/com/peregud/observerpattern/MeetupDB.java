package com.peregud.observerpattern;

import com.peregud.observerpattern.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.time.LocalDateTime;

public class MeetupDB {

    public LocalDateTime getMeetupTime(int id) {
        SessionUtil util = new SessionUtil();
        Session session = util.openSession();
        Transaction transaction = session.getTransaction();
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
        } finally {
            util.closeSession();
        }
        return result;
    }

    public String getLocation(int id) {
        SessionUtil util = new SessionUtil();
        Session session = util.openSession();
        Transaction transaction = session.getTransaction();
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
        } finally {
            util.closeSession();
        }
        return result;
    }

    public String getTopic(int id) {
        SessionUtil util = new SessionUtil();
        Session session = util.openSession();
        Transaction transaction = session.getTransaction();
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
        } finally {
            util.closeSession();
        }
        return result;
    }
}
