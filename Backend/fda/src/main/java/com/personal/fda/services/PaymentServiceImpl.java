package com.personal.fda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.fda.entities.Order;
import com.personal.fda.entities.Payment;
import com.personal.fda.repositories.OrderRepository;
import com.personal.fda.repositories.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderRepository oderRepository;
	
	public Payment addPayment(Long orderId) {
		Order order=this.oderRepository.getOrderByOrderId(orderId);
		Payment  payment=new Payment();
		payment.setOrder(order);
		return paymentRepository.save(payment);
	}
}
