package com.mongoDBS.morphia;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.QueryResults;

import com.mongoDBS.dao.CourseDAO;
import com.mongoDBS.dao.Student_Realized_CourseDAO;
import com.mongoDBS.entities.Course;
import com.mongoDBS.entities.Student_Realized_Course;
import com.mongoDBS.entities.Teacher;
import com.mongodb.MongoClient;

public class main {

	public final static String dbName = "highschool";
	public final static String entitiesPackage = "com.mongoDB.entities";
	
	public static void main( String[] args ) {
	    final Morphia morphia = new Morphia();
	    morphia.mapPackage(entitiesPackage);
	    MongoClient mongo = new MongoClient();
	    Datastore datastore = morphia.createDatastore(mongo, dbName);
	    
	    Student_Realized_CourseDAO dao = new Student_Realized_CourseDAO(morphia, mongo, dbName);
	    
	    Course c = new Course();
	    c.setId(100);
	    
	    QueryResults<Student_Realized_Course> resultado = dao.findNotesGraterThan(datastore, c,4);
	    System.out.println("Students with notes greater than 4 :"+resultado.count());
	   
	    Teacher t = new Teacher();
	    t.setId(3);
	    
	    
	    
	    CourseDAO courseDao = new CourseDAO(morphia, mongo, dbName);
	    
	    List<Course> result = courseDao.fetchCourseForTeacher(datastore,t).asList();
	    
	    System.out.println("Courses for teacher "+ t.getId() + "ordered by name");
	    for (Course course : result) {
			System.out.println(course.getCourse_name());
		}
	    
	}
}
