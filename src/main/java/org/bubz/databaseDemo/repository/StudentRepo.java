package org.bubz.databaseDemo.repository;

import org.bubz.databaseDemo.model.Student;
import org.springframework.boot.env.ConfigTreePropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    Student findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findStudentByGuardianName(String guardian_name);

// JPQL
    @Query("select s from Student s where s.studentEmail = ?1")
    Student getStudentByEmailAddress(String studentEmail);

// NATIVE QUERY
    @Query(
            value = "SELECT * FROM student_db s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String email_address);

// PARAM NATIVE QUERY
    @Query(
            value = "SELECT * FROM student_db s where s.first_name = :firstName AND s.last_name = :lastName",
            nativeQuery = true
    )
    Student findByFirstNameAndLastNameParam(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
