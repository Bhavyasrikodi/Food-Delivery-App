package com.personal.fda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Restaurant {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String location;
    private String contactNumber;

    @OneToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private RestaurantOwner owner;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(Long id, String name, String location, String contactNumber, RestaurantOwner owner) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.contactNumber = contactNumber;
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public RestaurantOwner getOwner() {
		return owner;
	}

	public void setOwner(RestaurantOwner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + ", contactNumber=" + contactNumber
				+ ", owner=" + owner + "]";
	}
    
    
}

