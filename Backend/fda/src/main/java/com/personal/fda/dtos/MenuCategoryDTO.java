package com.personal.fda.dtos;

public class MenuCategoryDTO {
	private String name;

	public MenuCategoryDTO(String name) {
		super();
		this.name = name;
	}

	public MenuCategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MenuCategoryDTO [name=" + name + "]";
	}
	

}
