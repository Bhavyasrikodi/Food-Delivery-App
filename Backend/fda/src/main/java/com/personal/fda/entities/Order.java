package com.personal.fda.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue
    private Long orderId;

    private LocalDateTime orderTime;
    private String status;
    private String shippingAddress;
    private Double totalPrice;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Restaurant restaurant;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long orderId, LocalDateTime orderTime, String status, String shippingAddress, Double totalPrice,
			Customer customer, Restaurant restaurant) {
		super();
		this.orderId = orderId;
		this.orderTime = orderTime;
		this.status = status;
		this.shippingAddress = shippingAddress;
		this.totalPrice = totalPrice;
		this.customer = customer;
		this.restaurant = restaurant;
	}





	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderTime=" + orderTime + ", status=" + status + ", shippingAddress="
				+ shippingAddress + ", totalPrice=" + totalPrice + ", customer=" + customer + ", restaurant="
				+ restaurant + "]";
	}

}
