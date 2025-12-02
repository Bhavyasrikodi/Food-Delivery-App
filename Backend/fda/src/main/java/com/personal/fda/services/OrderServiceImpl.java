package com.personal.fda.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.fda.entities.CartItem;
import com.personal.fda.entities.Customer;
import com.personal.fda.entities.Order;
import com.personal.fda.entities.OrderItem;
import com.personal.fda.entities.Restaurant;
import com.personal.fda.repositories.CartItemRepository;
import com.personal.fda.repositories.CustomerRepository;
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
	
	@Transactional
    public Order placeOrderFromCart(Long customerId) {
        Customer customer = customerRepository.getCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found for id: " + customerId);
        }

        List<CartItem> cartItems = cartItemRepository.cartItemsByCustomerId(customerId);
        if (cartItems == null || cartItems.isEmpty()) {
            throw new IllegalStateException("Cart is empty. Nothing to place an order for.");
        }
        String shippingAddress=customer.getAddress();
        
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

        cartItemRepository.deleteAll(cartItems);

        return savedOrder;
    }
}
