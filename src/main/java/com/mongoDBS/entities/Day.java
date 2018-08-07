package com.mongoDBS.entities;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("DAY")
public class Day {

	@Id
	private int id;

	@Property("day_name")
	private String day_name;

	public Day() {
		// TODO Auto-generated constructor stub
	}

	public Day(int id, String day_name) {
		this.id = id;
		this.day_name = day_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay_name() {
		return day_name;
	}

	public void setDay_name(String day_name) {
		this.day_name = day_name;
	}

}
