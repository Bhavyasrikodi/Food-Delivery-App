package com.personal.fda.services;

import com.personal.fda.entities.Payment;

public interface PaymentService {

	public Payment addPayment(Long orderId);
}
