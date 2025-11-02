package com.personal.fda.dtos;

import com.personal.fda.entities.Role;


public class AdminUserDTO {

	private String name;
    private String email;
    private String username;
    private String password;
    private Role role;
    
	public AdminUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminUserDTO(String name, String email, String username, String password, Role role) {
		super();
		this.name = name;
		this.email = email;
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
		return "AdminUserDTO [name=" + name + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
    
    
}
