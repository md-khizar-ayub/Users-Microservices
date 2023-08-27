package com.mka.users.service.UserService.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mka.users.service.UserService.entities.Rating;
import com.mka.users.service.UserService.entities.User;
import com.mka.users.service.UserService.exception.ResourceNotFoundException;
import com.mka.users.service.UserService.repository.UserRepository;

@Service
public class UserServiceImp implements UserServices {

	@Autowired
	private UserRepository userUepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User saveUser(User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserID(userId);
		return userUepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> user = userUepository.findAll();
		user = user.stream().map(u ->{
			try {
				List<Rating> rating = restTemplate.getForObject("http://RATING-SERVICE/getratingbyuserid/"+u.getUserID(), ArrayList.class);
				u.setRating(rating);
			} catch (Exception e) {
				
			}
			return u;
		}).collect(Collectors.toList());
		return user;
	}

	@Override
	public User getUserByID(String userId) {
		User user = userUepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException());
		try {
			//fetch data from rating
			//http://RATING-SERVICE/getratingbyuserid/3f256f56-415f-4048-b9f8-d2e3be26af03
			List<Rating> rating = restTemplate.getForObject("http://RATING-SERVICE/ratingservice/getratingbyuserid/"+userId, ArrayList.class);
			user.setRating(rating);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
