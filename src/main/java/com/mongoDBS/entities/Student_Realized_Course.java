package com.mongoDBS.entities;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity("STUDENT_REALIZED_COURSE")
public class StudentRealizedCourse {

	@Reference("student")
	private Student student;

	@Reference("course")
	private Course course;

	@Property("note_1")
	private double note_1;

	@Property("note_2")
	private double note_2;

	@Property("note_3")
	private double note_3;

	@Property("final_note")
	private double final_note;

	public Student_Realized_Course() {
	}

	public Student_Realized_Course(Student student, Course course, double note_1, double note_2,
			double note_3, double final_note) {
		
		this.student = student;
		this.course = course;
		this.note_1 = note_1;
		this.note_2 = note_2;
		this.note_3 = note_3;
		this.final_note = final_note;
	}

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public double getNote_1() {
		return note_1;
	}

	public void setNote_1(double note_1) {
		this.note_1 = note_1;
	}

	public double getNote_2() {
		return note_2;
	}

	public void setNote_2(double note_2) {
		this.note_2 = note_2;
	}

	public double getNote_3() {
		return note_3;
	}

	public void setNote_3(double note_3) {
		this.note_3 = note_3;
	}

	public double getFinal_note() {
		return final_note;
	}

	public void setFinal_note(double final_note) {
		this.final_note = final_note;
	}

}
