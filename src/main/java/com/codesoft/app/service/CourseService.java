package com.codesoft.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesoft.app.entities.Course;
import com.codesoft.app.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public Course updateCourse(Long id, Course updatedCourse) {
		Course course = courseRepository.findById(id).orElseThrow(()-> new RuntimeException("Course not found!"));
		course.setCourseName(updatedCourse.getCourseName());
        course.setDescription(updatedCourse.getDescription());
        course.setFee(updatedCourse.getFee());
        course.setStartDate(updatedCourse.getStartDate());
        course.setEndDate(updatedCourse.getEndDate());
        return courseRepository.save(course);
		
	}
}
