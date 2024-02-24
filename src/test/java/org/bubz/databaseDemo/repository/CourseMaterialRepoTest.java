package org.bubz.databaseDemo.repository;

import org.bubz.databaseDemo.model.Course;
import org.bubz.databaseDemo.model.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepoTest {

    @Autowired
    private CourseMaterialRepo courseMaterialRepo;

    @Test
    public void saveCourseMaterial() {
        Course newcourse =  Course.builder()
                .title("java")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("java@swanseauni.com")
                .course(newcourse)
                .build();
        courseMaterialRepo.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials =
                courseMaterialRepo.findAll();
        System.out.println(courseMaterials);
    }

}