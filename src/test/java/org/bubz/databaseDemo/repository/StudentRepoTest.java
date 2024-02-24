package org.bubz.databaseDemo.repository;

import org.bubz.databaseDemo.model.Course;
import org.bubz.databaseDemo.model.Guardian;
import org.bubz.databaseDemo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepoTest {

    @Autowired
    private StudentRepo  studentRepo;

    @Test
    public  void saveStudent(){

        Guardian newGuardian = Guardian.builder()
                .name("Bros")
                .email("bros@gmail.com")
                .mobile("0734678668")
                .build();

        Student student = Student.builder()
                .firstName("Charles")
                .lastName("Shing")
                .studentEmail("merg@gmail.com")
                .guardian(newGuardian)
                .build();
        studentRepo.save(student);
    }

    @Test
    public void printAll(){

        List<Student> students = studentRepo.findAll();
        System.out.println(students);
    }

    @Test
    public void findStudentByName(){
        Student s1 = studentRepo.findByFirstName("Charles");
        System.out.println(s1);
    }

    @Test
    public void findByFirstNameAndLastName(){
        Student s2 = studentRepo.findByFirstNameAndLastName("Charles", "Shing");
        System.out.println(s2);
    }

    @Test
    public void findStudentByGuardianName(){
        List<Student> s3 =studentRepo.findStudentByGuardianName("Bros");
        System.out.println(s3);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student s4 = studentRepo.getStudentByEmailAddress("merg@gmail.com");
        System.out.println(s4);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student s5 = studentRepo.getStudentByEmailAddressNative("merg@gmail.com");
        System.out.println(s5);
    }

    @Test
    public void findByFirstNameAndLastNameParam(){
        Student s6 = studentRepo.findByFirstNameAndLastNameParam("Charles", "Shing");
        System.out.println(s6);
    }

}