package com.codesoft.app.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	private LocalDate enrollmentDate;

	public Enrollment() {
	}
	
	public Enrollment(User user, Course course, LocalDate enrollmentDate) {
		super();
		this.id = id;
		this.user = user;
		this.course = course;
		this.enrollmentDate = enrollmentDate;
	}
	
	public Enrollment(Long id, User user, Course course, LocalDate enrollmentDate) {
		super();
		this.id = id;
		this.user = user;
		this.course = course;
		this.enrollmentDate = enrollmentDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", user=" + user + ", course=" + course + ", enrollmentDate=" + enrollmentDate
				+ "]";
	}
	
	
}
