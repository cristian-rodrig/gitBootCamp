package com.mongoDBS.entities;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity("COURSE")
public class Course {

	@Id
	private int id;

	@Property("course_name")
	private String course_name;

	@Property("hours_by_week")
	private int hours_by_week;

	@Property("time_start")
	private String time_start;

	@Property("time_end")
	private String time_end;

	@Reference("day_of_week")
	private Day day_of_week;

	@Reference("asigned_teacher")
	private Teacher teacher;

	public Course() {
	}

	public Course(int id, String course_name, int hours_by_week, String time_start, String time_end,
			Day day_of_week, Teacher teacher) {
		super();
		this.id = id;
		this.course_name = course_name;
		this.hours_by_week = hours_by_week;
		this.time_start = time_start;
		this.time_end = time_end;
		this.day_of_week = day_of_week;
		this.teacher = teacher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getHours_by_week() {
		return hours_by_week;
	}

	public void setHours_by_week(int hours_by_week) {
		this.hours_by_week = hours_by_week;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public Day getDay_of_week() {
		return day_of_week;
	}

	public void setDay_of_week(Day day_of_week) {
		this.day_of_week = day_of_week;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}