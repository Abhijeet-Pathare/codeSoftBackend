package com.codesoft.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesoft.app.entities.Enrollment;
import com.codesoft.app.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
	@Autowired
	private EnrollmentService enrollmentService;

	@PostMapping("/enroll")
	public ResponseEntity<Enrollment> enrollUserInCourse(@RequestParam Long userId, @RequestParam Long courseId) {
		Enrollment enrollment = enrollmentService.enrollUserInCourse(userId, courseId);
		return ResponseEntity.ok(enrollment);
	}

//	@GetMapping("/user/{userId}")
//	public ResponseEntity<List<Enrollment>> getEnrollmentsByUser(@PathVariable Long userId) {
//		List<Enrollment> enrollments = enrollmentService.getEnrollmentsByUser(userId);
//		return ResponseEntity.ok(enrollments);
//	}
//
//	@GetMapping("/course/{courseId}")
//	public ResponseEntity<List<Enrollment>> getEnrollmentsByCourse(@PathVariable Long courseId) {
//		List<Enrollment> enrollments = enrollmentService.getEnrollmentsByCourse(courseId);
//		return ResponseEntity.ok(enrollments);
//	}
}
