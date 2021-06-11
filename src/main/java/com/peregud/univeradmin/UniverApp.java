package com.peregud.univeradmin;

import com.peregud.univeradmin.model.*;
import com.peregud.univeradmin.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class UniverApp {

    public static void main(String[] args) {

        Admin admin = Admin.builder()
                .name("Name")
                .build();

        Student student = Student.builder()
                .firstName("First Name 1")
                .lastName("Last Name 1")
                .build();

        Course course = Course.builder()
                .name("Name")
                .admin(admin)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("First Name")
                .lastName("Last Name")
                .course(course)
                .admin(admin)
                .build();

        Set<Course> courseSet = new HashSet<>();
        courseSet.add(course);
        student.setCourses(courseSet);

        StudentResult studentResult = StudentResult.builder()
                .mark(5)
                .review("Review")
                .student(student)
                .teacher(teacher)
                .build();

        Task task = Task.builder()
                .taskName("Task")
                .student(student)
                .course(course)
                .studentResult(studentResult)
                .build();

        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.persist(student);
            entityManager.persist(teacher);
            entityManager.persist(admin);
            entityManager.persist(studentResult);
            entityManager.persist(task);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            HibernateUtil.close();
        }
    }
}
