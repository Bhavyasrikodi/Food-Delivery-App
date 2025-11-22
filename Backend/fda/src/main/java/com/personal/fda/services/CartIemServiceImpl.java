package com.personal.fda.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.fda.dtos.CartItemDTO;
import com.personal.fda.entities.CartItem;
import com.personal.fda.entities.Customer;
import com.personal.fda.entities.MenuItem;
import com.personal.fda.repositories.CartItemRepository;
import com.personal.fda.repositories.CustomerRepository;
import com.personal.fda.repositories.MenuItemRepository;

@Service
public class CartIemServiceImpl implements CartItemService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CartItemRepository cartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	public CartItem addToCart(Long customerId,CartItemDTO cartItemDTO) {
		CartItem item=this.modelMapper.map(cartItemDTO, CartItem.class);
		Customer customer=this.customerRepository.getCustomerById(customerId);
		MenuItem menuItem=this.menuItemRepository.getItemByNameAndRestaurant(cartItemDTO.getMenuItemName(), cartItemDTO.getRestaurantName());
		item.setMenuItem(menuItem);
		item.setCustomer(customer);
		return this.cartRepository.save(item);
	}
	
//	public CartItem addToCart(Long customerId, CartItemDTO cartItemDTO) {
//	    CartItem item = this.modelMapper.map(cartItemDTO, CartItem.class);
//
//	    Customer customer = this.customerRepository.getCustomerById(customerId);
//
//	    MenuItem menuItem = this.menuItemRepository.getItemByNameAndRestaurant(
//	            cartItemDTO.getMenuItemName(),
//	            cartItemDTO.getRestaurantName()
//	    );
//
//	    if (menuItem == null) {
//	        // throw your custom exception, or handle however you want
//	        throw new RuntimeException("Menu item not found for name: " 
//	                + cartItemDTO.getMenuItemName() 
//	                + " and restaurant: " 
//	                + cartItemDTO.getRestaurantName());
//	    }
//
//	    item.setMenuItem(menuItem);
//	    item.setCustomer(customer);
//
//	    return this.cartRepository.save(item);
//	}

}
