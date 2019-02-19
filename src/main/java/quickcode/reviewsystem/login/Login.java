package quickcode.reviewsystem.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
	
	@Autowired
	private UserService userservice;
	@Autowired
	private CoursesService coursesservice;
	@Autowired
	private ReviewsService reviewservice;
	
	@RequestMapping("/api/auth")
	public List<User> hi() {
		return userservice.getUsers();
	}
	

	@RequestMapping(method=RequestMethod.POST,value= "/api/auth")
	public Boolean authentication(@RequestBody User user) {
		return userservice.authenticateUser(user);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value= "/api/courses")
	public List<Course> fetchCourses(@RequestParam(name = "username") String uid) {
		return coursesservice.getUserCourses(uid);
	}
	
	
	@RequestMapping( method = RequestMethod.GET, value="api/courseReviews")
	public List<Review> fetchReviews(@RequestParam(name = "cid") String cid){
		
		return reviewservice.reviewList("select * from courses inner join reviews on courses.cid=reviews.cid and reviews.cid="+cid.replace("\"", "")+";");
	}
	
	@RequestMapping( method = RequestMethod.GET, value="api/userCoursesReviews")
	public List<Review> fetchUserCourses(@RequestParam(name = "username") String username){
		
		return reviewservice.reviewList("select * from courses inner join reviews on courses.cid=reviews.cid and reviews.uid=(select uid from users where username='"+username.replace("\"", "")+"');");
	}
}
