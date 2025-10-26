package com.personal.fda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Admin {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long id, String name, String email, User user) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.user = user;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", user=" + user + "]";
	}
    
    
}

