package com.personal.fda.dtos;

import com.personal.fda.entities.MenuItem;


public class CartItemDTO {

	private int quantity;
    private String menuItemName;
    private String restaurantName;
    
	public CartItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CartItemDTO(int quantity, String menuItemName, String restaurantName) {
		super();
		this.quantity = quantity;
		this.menuItemName = menuItemName;
		this.restaurantName = restaurantName;
	}



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getMenuItemName() {
		return menuItemName;
	}



	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}



	public String getRestaurantName() {
		return restaurantName;
	}



	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}



	@Override
	public String toString() {
		return "CartItemDTO [quantity=" + quantity + ", menuItemName=" + menuItemName + ", RestaurantName="
				+ restaurantName + "]";
	}

	
    
    
    
}
