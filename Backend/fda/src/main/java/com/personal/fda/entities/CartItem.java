package com.personal.fda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
    @Id @GeneratedValue
    private Long cartItemId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(Long cartItemId, int quantity, Customer customer, MenuItem menuItem) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.customer = customer;
		this.menuItem = menuItem;
	}

	

	public Long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + cartItemId + ", quantity=" + quantity + ", customer=" + customer + ", menuItem=" + menuItem
				+ "]";
	}
    
    
}
