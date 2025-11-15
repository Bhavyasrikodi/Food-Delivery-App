package com.personal.fda.dtos;

public class RestaurantDTO {

	private String name;
    private String location;
    private String contactNumber;
	public RestaurantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantDTO(String name, String location, String contactNumber) {
		super();
		this.name = name;
		this.location = location;
		this.contactNumber = contactNumber;
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
	@Override
	public String toString() {
		return "RestaurantDTO [name=" + name + ", location=" + location + ", contactNumber=" + contactNumber + "]";
	}
    
    
}
