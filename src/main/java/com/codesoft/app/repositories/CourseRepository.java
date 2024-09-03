package com.codesoft.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codesoft.app.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByCourseNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String keyword, String keyword2);

}
