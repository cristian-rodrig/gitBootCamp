package com.mongoDBS.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import com.mongoDBS.entities.Course;
import com.mongoDBS.entities.Teacher;
import com.mongodb.MongoClient;

public class CourseDAO extends BasicDAO<Course, String>{

	public CourseDAO(Morphia morphia, MongoClient mongo, String dbName) {
		super(mongo, morphia, dbName);
	}

	public QueryResults<Course> fetchCourseForTeacher(Datastore datastore, Teacher t) {
		Query<Course> query = datastore.createQuery(Course.class);
		
		query.and(query.criteria("teacher").equal(t));
		query.order("course_name");
		
		return find(query);
		
	}
}
