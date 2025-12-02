package com.personal.fda.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

import jakarta.transaction.Transactional;

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
	
	
	@Transactional
	public CartItem addToCart(Long customerId, CartItemDTO cartItemDTO) {
	    Customer customer = customerRepository.getCustomerById(customerId);
	    if (customer == null) {
	        throw new IllegalArgumentException("Customer not found: " + customerId);
	    }

	    MenuItem menuItem = menuItemRepository.getItemByNameAndRestaurant(
	            cartItemDTO.getMenuItemName(), cartItemDTO.getRestaurantName());
	    if (menuItem == null) {
	        throw new IllegalArgumentException("Menu item not found: " + cartItemDTO.getMenuItemName());
	    }

	    int addQty = cartItemDTO.getQuantity() != 0 ? cartItemDTO.getQuantity() : 1;
	    if (addQty <= 0) addQty = 1;

	    List<CartItem> existingItems = cartRepository.cartItemsByCustomerId(customerId);

	   
	    if (!existingItems.isEmpty()) {
	        Long existingRestaurantId = existingItems.get(0).getMenuItem().getRestaurant().getRestaurantId();
	        Long newRestaurantId = menuItem.getRestaurant().getRestaurantId();

	        if (!Objects.equals(existingRestaurantId, newRestaurantId)) {
	            throw new IllegalStateException("Cart contains items from another restaurant. Clear cart first.");
	        }

	        
	        Optional<CartItem> sameItemOpt = existingItems.stream()
	                .filter(ci -> Objects.equals(ci.getMenuItem().getMenuItemId(), menuItem.getMenuItemId()))
	                .findFirst();

	        if (sameItemOpt.isPresent()) {
	            CartItem existing = sameItemOpt.get();
	            int updatedQty = existing.getQuantity() + addQty;
	            existing.setQuantity(updatedQty);

	        
	            double addedPrice = menuItem.getPrice() * addQty;
	            existing.setTotalPrice(existing.getTotalPrice() + addedPrice);

	            return cartRepository.save(existing);
	        }
	    }

	    
	    CartItem item = modelMapper.map(cartItemDTO, CartItem.class);
	    item.setCustomer(customer);
	    item.setMenuItem(menuItem);
	    item.setQuantity(addQty);
	    item.setTotalPrice(menuItem.getPrice() * addQty);

	    return cartRepository.save(item);
	}

	public double getCartTotal(Long customerId) {
	    return cartRepository.cartItemsByCustomerId(customerId)
	            .stream()
	            .mapToDouble(ci -> ci.getTotalPrice())
	            .sum();
	}
}
