package com.codesoft.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesoft.app.entities.Course;
import com.codesoft.app.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;

	@GetMapping
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}

	@PostMapping
	public Course addCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}

	@PutMapping("/{id}")
	public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
		return courseService.updateCourse(id, course);
	}
}
