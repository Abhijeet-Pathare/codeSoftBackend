package com.codesoft.app.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private Long id;

	private String courseName;
	private String description;
	private double fee;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public Course() {
		
	}

	public Course(Long id, String courseName, String description, double fee, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.description = description;
		this.fee = fee;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", description=" + description + ", fee=" + fee
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
}
