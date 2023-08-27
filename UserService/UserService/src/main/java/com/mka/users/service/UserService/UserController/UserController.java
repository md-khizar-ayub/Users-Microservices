package com.mka.users.service.UserService.UserController;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mka.users.service.UserService.Service.UserServices;
import com.mka.users.service.UserService.entities.User;

@RestController
@RequestMapping("/userservice")
public class UserController {
	@Autowired
	private UserServices userServices;
	
	@PostMapping("/createuser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User createdUser = userServices.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
		
	}
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId){
		User user = userServices.getUserByID(userId);
		return ResponseEntity.ok(user);
		
	}
	@GetMapping("/getalluser")
	public ResponseEntity<List<User>> getUSer(){
		List<User> user = userServices.getAllUser();
		return ResponseEntity.ok(user);
		
	}
	
	

}
