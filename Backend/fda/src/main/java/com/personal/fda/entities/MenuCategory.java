package com.personal.fda.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class MenuCategory {
    @Id @GeneratedValue
    private Long menuCategoryId;
    private String name;
	public MenuCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuCategory(Long menuCategoryId, String name) {
		super();
		this.menuCategoryId = menuCategoryId;
		this.name = name;
	}
	
	
	public Long getMenuCategoryId() {
		return menuCategoryId;
	}
	public void setMenuCategoryId(Long menuCategoryId) {
		this.menuCategoryId = menuCategoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MenuCategory [id=" + menuCategoryId + ", name=" + name + "]";
	}

    
}
