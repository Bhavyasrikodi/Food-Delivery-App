package com.personal.fda.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class MenuCategory {
    @Id @GeneratedValue
    private Long menuCtegoryId;
    private String name;
	public MenuCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuCategory(Long menuCtegoryId, String name) {
		super();
		this.menuCtegoryId = menuCtegoryId;
		this.name = name;
	}
	
	
	public Long getMenuCtegoryId() {
		return menuCtegoryId;
	}
	public void setMenuCtegoryId(Long menuCtegoryId) {
		this.menuCtegoryId = menuCtegoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MenuCategory [id=" + menuCtegoryId + ", name=" + name + "]";
	}

    
}
