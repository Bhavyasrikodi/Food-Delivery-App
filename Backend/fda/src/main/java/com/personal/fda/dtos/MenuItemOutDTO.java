package com.personal.fda.dtos;

public class MenuItemOutDTO {

	private String name;
    private String description;
    private Double price;
    private String availabilityTime;
    private String dietaryInfo;
    private String tasteInfo;
    private String nutritionalInfo;
    private boolean inStock;
    private String RestaurantName;
    
	public MenuItemOutDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuItemOutDTO(String name, String description, Double price, String availabilityTime, String dietaryInfo,
			String tasteInfo, String nutritionalInfo, boolean inStock, String restaurantName) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.availabilityTime = availabilityTime;
		this.dietaryInfo = dietaryInfo;
		this.tasteInfo = tasteInfo;
		this.nutritionalInfo = nutritionalInfo;
		this.inStock = inStock;
		RestaurantName = restaurantName;
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
	public String getAvailabilityTime() {
		return availabilityTime;
	}
	public void setAvailabilityTime(String availabilityTime) {
		this.availabilityTime = availabilityTime;
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
	public String getRestaurantName() {
		return RestaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}
	@Override
	public String toString() {
		return "MenuItemOutDTO [name=" + name + ", description=" + description + ", price=" + price
				+ ", availabilityTime=" + availabilityTime + ", dietaryInfo=" + dietaryInfo + ", tasteInfo=" + tasteInfo
				+ ", nutritionalInfo=" + nutritionalInfo + ", inStock=" + inStock + ", RestaurantName=" + RestaurantName
				+ "]";
	}
    
    
}
