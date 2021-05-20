package com.peregud.sessionfactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Set;

public class SessionFactoryTest {
    protected static SessionFactory sessionFactory;
    protected static Session session;

    @BeforeClass
    public static void init() {
        sessionFactory = createSessionFactory();
        session = sessionFactory.openSession();
    }

    @AfterClass
    public static void tearDown() {
        session.clear();
        session.close();
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        Reflections reflections = new Reflections("com.peregud.sessionfactory.model");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);
        for (Class<?> clazz : classes) {
            configuration.addAnnotatedClass(clazz);
        }
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}
