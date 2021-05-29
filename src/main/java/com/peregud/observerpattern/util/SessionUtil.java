package com.peregud.observerpattern.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Set;

public class SessionUtil {
    private final SessionFactory sessionFactory;

    public SessionUtil() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        Reflections reflections = new Reflections("com.peregud.observerpattern.model");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);
        for (Class<?> clazz : classes) {
            configuration.addAnnotatedClass(clazz);
        }
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession() {
        sessionFactory.close();
    }
}
