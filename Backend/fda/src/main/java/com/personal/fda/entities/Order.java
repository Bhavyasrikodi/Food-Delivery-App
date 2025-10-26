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
    private Long id;

    private LocalDateTime orderTime;
    private String status;
    private String shippingAddress;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Restaurant restaurant;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, LocalDateTime orderTime, String status, String shippingAddress, Customer customer,
			Restaurant restaurant) {
		super();
		this.id = id;
		this.orderTime = orderTime;
		this.status = status;
		this.shippingAddress = shippingAddress;
		this.customer = customer;
		this.restaurant = restaurant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTime=" + orderTime + ", status=" + status + ", shippingAddress="
				+ shippingAddress + ", customer=" + customer + ", restaurant=" + restaurant + "]";
	}

}
