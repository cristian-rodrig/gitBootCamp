package topic4.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySqlDB {

	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/highschool?"
                            + "user=root&password=9430"+
                            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            
            
            //List students and teachers for a given course
            String courseId = "100";
          
            resultSet = statement.executeQuery("Select c.course_name, t.first_name as TEACHER_NAME, t.last_name as TEACHER_LAST, s.first_name as STUDENT_NAME, s.last_name AS STUDENT_LAST_NAME "
            		+ "from STUDENT_REALIZED_COURSE src "
            		+ "join COURSE c on c.id_course = src.fk_course "
            		+ "join TEACHER t on t.id_teacher = c.assigned_teacher "
            		+ "join STUDENT s on src.fk_student = s.id_student "
            		+" ORDER BY STUDENT_LAST_NAME ");
            writeResultEx3(resultSet);
            
            
            //Percentage of students that passed/failed a given course
            resultSet = statement.executeQuery(" SELECT c.course_name, count(*) * 100 / totalStudents as passed "
            		+ "from STUDENT_REALIZED_COURSE src "
            		+ "join COURSE c on c.id_course = src.fk_course "
            		+ "join (select count(*) as totalStudents, s.fk_course from STUDENT_REALIZED_COURSE s group by s.fk_course) passed ON passed.fk_course = src.fk_course "
            		+ "where src.final_note > 7 AND c.id_course = " + courseId);
            writeResultEx4(resultSet);
            
            
            //For a given teacher, list the timeline for each course that he is assigned to (ordered by date), and the course name.
            String teacherId = "3";
            
            resultSet = statement.executeQuery("Select t.first_name as TEACHER_NAME, t.last_name as TEACHER_LAST, c.course_name as COURSE_NAME, d.day_name as DAY_OF_WEEK, c.time_start, c.time_end "
            		+ "FROM TEACHER t "
            		+ "JOIN COURSE c on c.assigned_teacher = t.id_teacher "
            		+ "JOIN DAY d on d.id_day = c.day_of_week "
            		+ "WHERE t.id_teacher = "+ teacherId
            		+ " ORDER BY c.day_of_week, c.time_start");
            writeResultEx5(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }
    
	/**
	 * For a given teacher, list the timeline for each course that he is
	 * assigned to (ordered by date), and the course name. The format should be:
	 * 
	 * Teacher: <last-name>, <first-name> 
	 * Schedule: 
	 * Monday 09:00 - 11:00: <course-name> 
	 * Monday 15:00 - 17:30: <course-name> 
	 * Friday 08:45 - 10:40: <course-name>
	 */
	private void writeResultEx5(ResultSet resultSet) throws SQLException {
		boolean started = false;
        while (resultSet.next()) { 
            if(!started){
            	started = true;
            	System.out.println(" ");
            	System.out.println("For a given teacher, list the timeline for each course that he is assigned to");
            	System.out.println("///////////////////////////");
            	String teacherName = resultSet.getString("TEACHER_NAME");
                String teacherLast = resultSet.getString("TEACHER_LAST");
                System.out.println("Teacher: "+ teacherName + " " + teacherLast);
                System.out.println("Schedule: ");
            }
            
            String dayOfWeek = resultSet.getString("DAY_OF_WEEK");
            String timeStart = resultSet.getString("time_start");
            String timeEnd = resultSet.getString("time_end");
            String courseName = resultSet.getString("COURSE_NAME");
            
            System.out.println(dayOfWeek + " " + timeStart  +"-"+ timeEnd +":"+ courseName);
        }
		
	}

	private void writeResultEx4(ResultSet resultSet2) throws SQLException {
		System.out.println(" ");
		System.out.println("Percentage of students that passed/failed a given course.");
    	System.out.println("//////////////////////////////");
		while (resultSet.next()) { 
			String courseName = resultSet2.getString("course_name"); 
			int percentage = resultSet2.getInt("passed"); 
			System.out.println("Percentage of students that passed "+courseName +": "+percentage+"%");
		}
	}

	/**
	 * List students and teachers for a given course. The output format should
	 * be:
	 * 
	 * Course: <course-name> 
	 * Teacher: <last-name>, <first-name> 
	 * Students:
	 * <last-name>, <first-name> (ordered by alphabetically by last name)
	 */
    private void writeResultEx3(ResultSet resultSet) throws SQLException {
    	boolean started = false;
        while (resultSet.next()) { 
            if(!started){
            	started = true;
            	System.out.println(" ");
            	System.out.println("List students and teachers for a given course");
            	System.out.println("//////////////////////////////");
            	String courseName = resultSet.getString("course_name");
            	System.out.println("Course: "+courseName);
            	String teacherName = resultSet.getString("TEACHER_NAME");
                String teacherLast = resultSet.getString("TEACHER_LAST");
                System.out.println("Teacher: "+ teacherName + " " + teacherLast);
                System.out.println("Students: ");
            }
            
            String studentName = resultSet.getString("STUDENT_NAME");
            String studentLast = resultSet.getString("STUDENT_LAST_NAME");
            System.out.println(studentName+" "+studentLast);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
