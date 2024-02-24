package org.bubz.databaseDemo.repository;

import org.bubz.databaseDemo.model.Course;
import org.bubz.databaseDemo.model.Student;
import org.bubz.databaseDemo.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void printCourseDetails(){
        List<Course> courses =
                courseRepo.findAll();
        System.out.println(courses);
    }

    @Test
    public void addTeacherStudentCourses() {
         Teacher teacher1 = Teacher.builder()
                 .firstName("Suberu")
                 .lastName("owoeye")
                 .build();

         Student student2 = Student.builder()
                 .firstName("Dan")
                 .lastName("Mike")
                 .studentEmail("subrah@gmail.com")
                 .build();

         Course course = Course.builder()
                 .title("java")
                 .credit(6)
                 .teacher(teacher1)
                 .build();

         course.addStudent(student2);
         courseRepo.save(course);
    }

}