package com.personal.fda.dtos;

import com.personal.fda.entities.Role;

public class CustomerUserDTO {

	 private String name;
	    private String email;
	    private String contactNumber;
	    private String address;
	    private String username;
	    private String password;
	    private Role role;
		public CustomerUserDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public CustomerUserDTO(String name, String email, String contactNumber, String address, String username,
				String password, Role role) {
			super();
			this.name = name;
			this.email = email;
			this.contactNumber = contactNumber;
			this.address = address;
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
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
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
			return "CustomerUserDTO [name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
					+ ", address=" + address + ", username=" + username + ", password=" + password + ", role=" + role
					+ "]";
		}
	    
	    
}
