package com.mka.users.service.UserService.entities;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "micro_users")
public class User {


	@Id
	@Column(name = "ID", length = 100)
	private String userID;
	
	@Column(name ="NAME")
	private String name;
	
	@Column(name ="EMAIL")
	private String email;
	
	@Column(name ="ABOUT")
	private String about;
	
	@Transient
	private List<Rating> rating = new ArrayList<>();
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", email=" + email + ", about=" + about + ", rating="
				+ rating + "]";
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	

}
