package com.mka.users.service.UserService.Service;

import java.util.List;

import com.mka.users.service.UserService.entities.User;

public interface UserServices {
	
	
	//save user
	User saveUser(User user);
	
	
	//get all users
	List<User> getAllUser();
	
	//get user of given id
	User getUserByID(String userId);

}
