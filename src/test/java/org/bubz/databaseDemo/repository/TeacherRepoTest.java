package org.bubz.databaseDemo.repository;

import org.bubz.databaseDemo.model.Course;
import org.bubz.databaseDemo.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    public void saveTeacher() {
        Course course1 =  Course.builder()
                .title("java")
                .credit(6)
                .build();

        Course course2 = Course.builder()
                .title("sql")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Samson")
                .lastName("Owoeye")
                .course(List.of(course1, course2))
                .build();
        teacherRepo.save(teacher);
    }

}