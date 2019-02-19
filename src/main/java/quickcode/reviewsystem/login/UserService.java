package quickcode.reviewsystem.login;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	private List<User> users= new ArrayList<>( Arrays.asList());
	
	public List<User> getUsers() {
		DatabaseConnection obj = new DatabaseConnection();
		try {
			users=obj.executeQuery("SELECT * FROM USERS;");
			obj.closeConnections();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

	
	
	

	public Boolean authenticateUser(User user) {
		// TODO Auto-generated method stub
		DatabaseConnection obj = new DatabaseConnection();
		try {
			users=obj.executeQuery("SELECT * FROM USERS where username='"+user.getUsername()+"';");
			obj.closeConnections();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(users.size()>0 && user.getPassword().equals(users.get(0).getPassword())) {
			return true;
		}
		return false;
	}
	
	

}
