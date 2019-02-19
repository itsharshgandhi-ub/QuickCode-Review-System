package quickcode.reviewsystem.login;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReviewsService {
	private List<Review> reviews= new ArrayList<>( Arrays.asList());
	
	public List<Review> reviewList(String sql) {
		DatabaseConnection obj = new DatabaseConnection();
		try {
//			System.out.println(cid);
			reviews=(List<Review>) obj.courseReviews(sql);
			obj.closeConnections();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reviews;
	}

}
