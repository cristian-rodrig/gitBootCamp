package com.mongoDBS.entities;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("Students")
public class Student {
	
	@Property("id_student")
	private int id_student;
	
	@Property("first_name")
	private String first_name;
	
	@Property("last_Name")
	private String last_name;
	
	@Property("Date_of_birth")
	private Date birthday;

	public Student(){
	}
	
	public Student( int id_student, String first_name, String last_name, Date birthday) {
		this.id_student = id_student;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birthday = birthday;
	}

		
	public String getfirstname() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
