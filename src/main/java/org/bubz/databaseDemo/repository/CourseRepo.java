package org.bubz.databaseDemo.repository;

import org.bubz.databaseDemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
