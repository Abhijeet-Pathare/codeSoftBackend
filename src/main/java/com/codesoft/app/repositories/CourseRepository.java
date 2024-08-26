package com.codesoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codesoft.app.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
