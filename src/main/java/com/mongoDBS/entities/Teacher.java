package com.mongoDBS.entities;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("TEACHER")
public class Teacher {

	@Id
	private int id;
	
	@Property("first_name")
	private String first_name;
	
	@Property("last_name")
	private String last_name;
	
	public Teacher(){
	}
	
	public Teacher(int id,int id_teacher, String first_name, String last_name) {
		this.id = id;
		this.id = id_teacher;
		this.first_name = first_name;
		this.last_name = last_name;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getFirstName() {
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

	}
