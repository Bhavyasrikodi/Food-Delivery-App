package com.personal.fda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.fda.entities.Order;
import com.personal.fda.services.OrderService;

@RestController
@RequestMapping("/api/v1/fda/order")
@ResponseBody
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/placeOrder")
    public ResponseEntity<Order> placeOrder(@RequestParam Long customerId) {
        Order order = orderService.placeOrderFromCart(customerId);
        return ResponseEntity.ok(order);
    }
	
	@PostMapping("/orderDirect")
	public ResponseEntity<Order> placeDirectOrder(
	        @RequestParam Long customerId,
	        @RequestParam Long menuItemId,
	        @RequestParam int quantity) {

	    return ResponseEntity.ok(
	            orderService.placeDirectOrder(customerId, menuItemId, quantity)
	    );
	}
}
