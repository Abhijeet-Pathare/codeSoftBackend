package com.codesoft.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesoft.app.entities.Course;
import com.codesoft.app.entities.Enrollment;
import com.codesoft.app.entities.User;
import com.codesoft.app.repositories.CourseRepository;
import com.codesoft.app.repositories.EnrollmentRepository;
import com.codesoft.app.repositories.UserRepository;

@Service
public class EnrollmentService {
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Enrollment enrollUserInCourse(Long userId,Long courseId) {
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
		Course course = courseRepository.findById(courseId).orElseThrow(()-> new RuntimeException("Course not found"));
		
		Enrollment enrollment = new Enrollment();
		enrollment.setCourse(course);
		enrollment.setEnrollmentDate(LocalDate.now());
		enrollment.setUser(user);
		return enrollmentRepository.save(enrollment);
	}
}
