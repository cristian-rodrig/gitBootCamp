package com.mongoDBS.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import com.mongoDBS.entities.Course;
import com.mongoDBS.entities.Student_Realized_Course;
import com.mongodb.MongoClient;
	
public class Student_Realized_CourseDAO extends BasicDAO<Student_Realized_Course, String>{

		public Student_Realized_CourseDAO(Morphia morphia, MongoClient mongo, String dbName) {
			super(mongo, morphia, dbName);
		}
		
		public QueryResults<Student_Realized_Course> findNotesGraterThan(Datastore datastore, Course course, int final_note) {
			Query<Student_Realized_Course> query = datastore.createQuery(Student_Realized_Course.class);
			query.and(query.criteria("course").equal(course))
			.and(query.criteria("final_note").greaterThanOrEq(final_note));
			return find(query);
		}
}