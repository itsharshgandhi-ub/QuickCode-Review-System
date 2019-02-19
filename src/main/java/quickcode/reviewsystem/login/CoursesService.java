package quickcode.reviewsystem.login;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CoursesService {
	
	private List<Course> courses= new ArrayList<>( Arrays.asList());
	
	public List<Course> getUserCourses(String uid) {
		DatabaseConnection obj = new DatabaseConnection();
		try {
			courses=obj.courseData("SELECT * FROM COURSES;");
			obj.closeConnections();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courses;
	}

}
