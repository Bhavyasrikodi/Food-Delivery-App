package com.personal.fda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class RestaurantOwner {
    @Id @GeneratedValue
    private Long restaurantOwnerId;

    private String name;
    private String email;
    private String contactNumber;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

	public RestaurantOwner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantOwner(Long restaurantOwnerId, String name, String email, String contactNumber, User user) {
		super();
		this.restaurantOwnerId = restaurantOwnerId;
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.user = user;
	}
	
	

	public Long getRestaurantOwnerId() {
		return restaurantOwnerId;
	}

	public void setRestaurantOwnerId(Long restaurantOwnerId) {
		this.restaurantOwnerId = restaurantOwnerId;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RestaurantOwner [id=" + restaurantOwnerId + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", user=" + user + "]";
	}
    
    
}
