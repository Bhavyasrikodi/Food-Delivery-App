package com.personal.fda.services;

import com.personal.fda.dtos.CartItemDTO;
import com.personal.fda.entities.CartItem;

public interface CartItemService {

	public CartItem addToCart(Long customerId,CartItemDTO cartItemDTO);
	
	public double getCartTotal(Long customerId);
}
