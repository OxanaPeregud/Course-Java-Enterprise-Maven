package com.peregud.iteratorcompositepattern.util;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Set;

@UtilityClass
public class SessionUtil {
    @Getter
    private SessionFactory sessionFactory;

    public SessionFactory sessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            Reflections reflections = new Reflections("com.peregud.iteratorcompositepattern.model");
            Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);
            for (Class<?> clazz : classes) {
                configuration.addAnnotatedClass(clazz);
            }
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    public Session openSession() {
        return sessionFactory().openSession();
    }

    public void closeSession() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
