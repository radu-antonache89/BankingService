package service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import model.User;

@Service
public class UserService {
	
	LinkedHashMap<String, User> users = new LinkedHashMap<String, User>();

	public UserService() {
		User user1 = new User();
		user1.setId("1");
		user1.setUsername("JohnDoe");
		user1.setPassword("mypass");
		users.put("1", user1);

		User user2 = new User();
		user2.setId("2");
		user2.setUsername("JaneDoe");
		user2.setPassword("newpass");
		users.put("2", user2);

		User user3 = new User();
		user3.setId("3");
		user3.setUsername("SteveSmith");
		user3.setPassword("anotherpass");
		users.put("3", user3);
	}

	public User getUserWithId(String id) {
		if (users.containsKey(id))
			return users.get(id);
		else
			return null;
	}
	
	public User getUserByUsername(String p_username) {
		for (Map.Entry<String, User> entry : users.entrySet()) {
			User user = entry.getValue();
			if (user.getUsername().equals(p_username)){
				return user;
			}
		}
		return null;
	}
	
	public boolean isValidUser(String p_username, String p_password) {
		boolean isValidUser = false;
		for (Map.Entry<String, User> entry : users.entrySet()) {
			User user = entry.getValue();
			if (user.getUsername().equals(p_username) && user.getPassword().equals(p_password)) {
				isValidUser = true;
				break;
			}
		}
		return isValidUser;
	}

	public LinkedHashMap<String, User> getAll() {
		return users;
	}
}
