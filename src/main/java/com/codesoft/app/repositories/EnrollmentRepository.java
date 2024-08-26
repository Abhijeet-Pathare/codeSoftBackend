package com.codesoft.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codesoft.app.entities.Course;
import com.codesoft.app.entities.Enrollment;
import com.codesoft.app.entities.User;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	List<Enrollment> findByUser(User user);

	List<Enrollment> findByCourse(Course course);
}
