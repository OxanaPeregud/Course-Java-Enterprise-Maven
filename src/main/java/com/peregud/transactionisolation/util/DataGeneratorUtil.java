package com.peregud.transactionisolation.util;

import com.peregud.transactionisolation.model.*;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class DataGeneratorUtil {
    private final List<String> FIRST_NAMES;
    private final List<String> LAST_NAMES;
    private final List<String> COURSES;
    private final List<String> REVIEW;
    private final List<String> TASK;
    private final Random RANDOM = new Random();

    static {
        FIRST_NAMES = Arrays.asList("James", "Robert", "Michael", "David", "Richard");
        LAST_NAMES = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones");
        COURSES = Arrays.asList("Java", "C++", "Python", "JavaScript", "Swift");
        REVIEW = Arrays.asList("Excellent", "Good", "Not Bad", "Bad");
        TASK = Arrays.asList("Task 1", "Task 2", "Task 3", "Task 4", "Task 5");
    }

    public List<Admin> buildAdmin(int count) {
        return Stream.generate(() -> Admin.builder()
                .name(FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())))
                .build())
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<Course> buildCourse(int count) {
        return Stream.generate(() -> Course.builder()
                .name(COURSES.get(RANDOM.nextInt(COURSES.size())))
                .admin(DataUtil.get(Admin.class, (int) (Math.random() * ((count + 1) - 1) + 1)))
                .build())
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<Student> buildStudent(int count) {
        return Stream.generate(() -> Student.builder()
                .firstName(FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())))
                .lastName(LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())))
                .build())
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<StudentResult> buildStudentResult(int count) {
        return Stream.generate(() -> StudentResult.builder()
                .mark((int) (Math.random() * (11 - 1)) + 1)
                .review(REVIEW.get(RANDOM.nextInt(REVIEW.size())))
                .student(DataUtil.get(Student.class, (int) (Math.random() * ((count + 1) - 1) + 1)))
                .teacher(DataUtil.get(Teacher.class, (int) (Math.random() * ((count + 1) - 1) + 1)))
                .build())
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<Task> buildTask(int count) {
        return Stream.generate(() -> Task.builder()
                .taskName(TASK.get(RANDOM.nextInt(TASK.size())))
                .student(DataUtil.get(Student.class, (int) (Math.random() * ((count + 1) - 1) + 1)))
                .course(DataUtil.get(Course.class, (int) (Math.random() * ((count + 1) - 1) + 1)))
                .studentResult(DataUtil.get(StudentResult.class, (int) (Math.random() * ((count + 1) - 1) + 1)))
                .build())
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<Teacher> buildTeacher(int count) {
        return Stream.generate(() -> Teacher.builder()
                .firstName(FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())))
                .lastName(LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())))
                .course(DataUtil.get(Course.class, (int) (Math.random() * ((count + 1) - 1) + 1)))
                .admin(DataUtil.get(Admin.class, (int) (Math.random() * ((count + 1) - 1) + 1)))
                .build())
                .limit(count)
                .collect(Collectors.toList());
    }
}
