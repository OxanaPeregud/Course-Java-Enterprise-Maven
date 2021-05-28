package com.peregud.subclass;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

public class Starter {
    public static void main(String[] args) {

        Task task = Task.builder()
                .name("Task Name")
                .description("Task Description")
                .build();

        Address address = Address.builder()
                .street("Street")
                .city("City")
                .build();

        HomeTask homeTask = HomeTask.builder()
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .address(address)
                .build();

        WorkTask workTask = WorkTask.builder()
                .cost(100)
                .build();

        EntityManager entityManager = HibernateUtil.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.persist(homeTask);
        entityManager.persist(workTask);
        entityManager.getTransaction().commit();
        System.out.println(entityManager.find(Task.class, task.getId()));
        System.out.println(entityManager.find(HomeTask.class, task.getId()));
        System.out.println(entityManager.find(WorkTask.class, task.getId()));
        HibernateUtil.close();
    }
}
