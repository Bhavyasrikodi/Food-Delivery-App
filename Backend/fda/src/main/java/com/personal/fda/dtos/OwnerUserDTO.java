package com.personal.fda.dtos;

import com.personal.fda.entities.Role;

public class OwnerUserDTO {

	private String name;
    private String email;
    private String contactNumber;
    private String username;
    private String password;
    private Role role;
	public OwnerUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OwnerUserDTO(String name, String email, String contactNumber, String username, String password, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.username = username;
		this.password = password;
		this.role = role;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "OwnerUserDTO [name=" + name + ", email=" + email + ", contactNumber=" + contactNumber + ", username="
				+ username + ", password=" + password + ", role=" + role + "]";
	}
    
    
}
