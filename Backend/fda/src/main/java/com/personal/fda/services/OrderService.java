package com.personal.fda.services;

import com.personal.fda.entities.Order;

public interface OrderService {

	public Order placeOrderFromCart(Long customerId);
}
