package com.personal.fda.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.fda.entities.CartItem;
import com.personal.fda.entities.Customer;
import com.personal.fda.entities.MenuItem;
import com.personal.fda.entities.Order;
import com.personal.fda.entities.OrderItem;
import com.personal.fda.entities.Restaurant;
import com.personal.fda.repositories.CartItemRepository;
import com.personal.fda.repositories.CustomerRepository;
import com.personal.fda.repositories.MenuItemRepository;
import com.personal.fda.repositories.OrderItemRepository;
import com.personal.fda.repositories.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Transactional
	public Order placeOrderFromCart(Long customerId) {

		Customer customer = customerRepository.getCustomerById(customerId);
	   

	    List<CartItem> cartItems = cartItemRepository.cartItemsByCustomerId(customerId);
	   

	    String shippingAddress = customer.getAddress();
	    Restaurant restaurant = cartItems.get(0).getMenuItem().getRestaurant();

	    
	    Order order = new Order();
	    order.setCustomer(customer);
	    order.setOrderTime(LocalDateTime.now());
	    order.setStatus("PLACED");
	    order.setShippingAddress(shippingAddress);
	    order.setRestaurant(restaurant);

	 
	    Order savedOrder = orderRepository.save(order);

	    List<OrderItem> orderItems = cartItems.stream().map(ci -> {
	        OrderItem oi = new OrderItem();
	        oi.setOrder(savedOrder);
	        oi.setMenuItem(ci.getMenuItem());
	        oi.setQuantity(ci.getQuantity());
	        oi.setPrice(ci.getTotalPrice());
	        return oi;
	    }).collect(Collectors.toList());

	    orderItemRepository.saveAll(orderItems);

	    
	    double totalPrice = orderItems.stream()
	            .mapToDouble(OrderItem::getPrice)
	            .sum();

	    savedOrder.setTotalPrice(totalPrice);
	    orderRepository.save(savedOrder);

	   
	    cartItemRepository.deleteAll(cartItems);

	    emailService.sendOrderConfirmationMail(
	            customer.getEmail(),
	            customer.getName(),
	            savedOrder.getOrderId(),
	            totalPrice
	    );

	    return savedOrder;
	    
	}
	
	@Transactional
	public Order placeDirectOrder(Long customerId, Long menuItemId, int quantity) {

	    Customer customer = customerRepository.getCustomerById(customerId);
	    if (customer == null) {
	        throw new IllegalArgumentException("Customer not found");
	    }

	    MenuItem menuItem = menuItemRepository.findById(menuItemId)
	            .orElseThrow(() -> new IllegalArgumentException("Menu item not found"));

	    Restaurant restaurant = menuItem.getRestaurant();

	    Order order = new Order();
	    order.setCustomer(customer);
	    order.setOrderTime(LocalDateTime.now());
	    order.setStatus("PLACED");
	    order.setShippingAddress(customer.getAddress());
	    order.setRestaurant(restaurant);

	    Order savedOrder = orderRepository.save(order);

	   
	    double totalPrice = menuItem.getPrice() * quantity;

	    OrderItem orderItem = new OrderItem();
	    orderItem.setOrder(savedOrder);
	    orderItem.setMenuItem(menuItem);
	    orderItem.setQuantity(quantity);
	    orderItem.setPrice(totalPrice);

	    orderItemRepository.save(orderItem);

	    savedOrder.setTotalPrice(totalPrice);
	    orderRepository.save(savedOrder);

	    emailService.sendOrderConfirmationMail(
	            customer.getEmail(),
	            customer.getName(),
	            savedOrder.getOrderId(),
	            totalPrice
	    );

	    return savedOrder;
	}



}
