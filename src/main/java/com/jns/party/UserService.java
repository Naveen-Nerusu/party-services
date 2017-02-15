package com.jns.party;

import java.util.List;

public interface UserService {
	User save(User user) throws UserAlreadyExistsException;

	List<User> getUsers();
	
	User getUser(String id);
}
