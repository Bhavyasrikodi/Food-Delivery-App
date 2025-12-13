package com.personal.fda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MenuItem {
    @Id @GeneratedValue
    private Long menuItemId;
    private String name;
    private String description;
    private Double price;
   
    private String dietaryInfo;
    private String tasteInfo;
    private String nutritionalInfo;
    private boolean inStock;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private MenuCategory category;

	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuItem(Long menuItemId, String name, String description, Double price, String dietaryInfo,
			String tasteInfo, String nutritionalInfo, boolean inStock, Restaurant restaurant, MenuCategory category) {
		super();
		this.menuItemId = menuItemId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.dietaryInfo = dietaryInfo;
		this.tasteInfo = tasteInfo;
		this.nutritionalInfo = nutritionalInfo;
		this.inStock = inStock;
		this.restaurant = restaurant;
		this.category = category;
	}

	

	public Long getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(Long menuItemId) {
		this.menuItemId = menuItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



	public String getDietaryInfo() {
		return dietaryInfo;
	}

	public void setDietaryInfo(String dietaryInfo) {
		this.dietaryInfo = dietaryInfo;
	}

	public String getTasteInfo() {
		return tasteInfo;
	}

	public void setTasteInfo(String tasteInfo) {
		this.tasteInfo = tasteInfo;
	}

	public String getNutritionalInfo() {
		return nutritionalInfo;
	}

	public void setNutritionalInfo(String nutritionalInfo) {
		this.nutritionalInfo = nutritionalInfo;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public MenuCategory getCategory() {
		return category;
	}

	public void setCategory(MenuCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + menuItemId + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", dietaryInfo=" + dietaryInfo + ", tasteInfo=" + tasteInfo
				+ ", nutritionalInfo=" + nutritionalInfo + ", inStock=" + inStock + ", restaurant=" + restaurant
				+ ", category=" + category + "]";
	}
    
    
}
