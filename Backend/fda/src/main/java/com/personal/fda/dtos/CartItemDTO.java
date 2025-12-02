package com.personal.fda.dtos;


public class CartItemDTO {

	private int quantity;
    private String menuItemName;
    private String restaurantName;
    private Double totalPrice;
    
	public CartItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CartItemDTO(int quantity, String menuItemName, String restaurantName,Double totalPrice) {
		super();
		this.quantity = quantity;
		this.menuItemName = menuItemName;
		this.restaurantName = restaurantName;
		this.totalPrice=totalPrice;
	}


	

	public Double getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
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
		return "CartItemDTO [quantity=" + quantity + ", menuItemName=" + menuItemName + ", restaurantName="
				+ restaurantName + ", totalPrice=" + totalPrice + "]";
	}



	

	
    
    
    
}
