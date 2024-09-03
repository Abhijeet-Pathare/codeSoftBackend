package com.codesoft.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesoft.app.entities.Course;
import com.codesoft.app.repositories.CourseRepository;
import com.codesoft.app.service.CourseService;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:3000")
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
	
	@GetMapping("/search")
	public List<Course> searchCourses(@RequestParam(required=false) String keyword){
		if(keyword == null || keyword.isEmpty()) {
			return courseService.getAllCourses();
		}
		return courseService.findByCourseNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword,keyword);
	}
}
