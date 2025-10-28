package com.personal.fda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
    @Id @GeneratedValue
    private Long orderItemId;

    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Long orderItemId, int quantity, double price, Order order, MenuItem menuItem) {
		super();
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.price = price;
		this.order = order;
		this.menuItem = menuItem;
	}


	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + orderItemId + ", quantity=" + quantity + ", price=" + price + ", order=" + order
				+ ", menuItem=" + menuItem + "]";
	}
    
}
