package com.personal.fda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
    @Id @GeneratedValue
    private Long customerId;

    private String name;
    private String email;
    private String contactNumber;
    private String address;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long customerId, String name, String email, String contactNumber, String address, User user) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.address = address;
		this.user = user;
	}

	

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [id=" + customerId + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", address=" + address + ", user=" + user + "]";
	}
    
    
}
