package quickcode.reviewsystem.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseConnection {
	Connection c = null;
	Statement stmt = null;

	public DatabaseConnection() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("org.postgresql.Driver");
			this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "harsh", "harsh");
			this.c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			this.stmt = c.createStatement();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}

	public List<Review> courseReviews(String sql) throws SQLException {
		List<Review> reviews = new ArrayList<>(Arrays.asList());

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String cname = rs.getString("cname");
			String detail = rs.getString("detail");
			String cid = rs.getString("cid");
			String rid = rs.getString("rid");
			String uid = rs.getString("uid");
			String content = rs.getString("content");
			String instructorperformance = rs.getString("instructorPerformance");
			String videoquality = rs.getString("videoQuality");
			String overallexperience = rs.getString("overallExperience");
			String comments = rs.getString("comments");

			reviews.add(new Review(cname, detail,cid, rid,uid, content, instructorperformance, videoquality,overallexperience,comments));

		}
		rs.close();
		return reviews;
	}

	public List<Course> courseData(String sql) throws SQLException {

		List<Course> courses = new ArrayList<>(Arrays.asList());

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String cid = rs.getString("cid");
			String cname = rs.getString("cname");
			String detail = rs.getString("detail");

			courses.add(new Course(cid, cname, detail));

		}
		rs.close();
		return courses;

	}

	public List<User> executeQuery(String sql) throws SQLException {

		List<User> users = new ArrayList<>(Arrays.asList());
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String id = rs.getString("id");
			String username = rs.getString("username");
			String password = rs.getString("password");

			users.add(new User(id, username, password));
//			System.out.println("ID = " + id);
//			System.out.println("NAME = " + name);
//			System.out.println("AGE = " + age);

//			System.out.println();
		}
		rs.close();
		return users;

	}

	public void closeConnections() throws SQLException {
		stmt.close();
		c.close();
	}

	

}
