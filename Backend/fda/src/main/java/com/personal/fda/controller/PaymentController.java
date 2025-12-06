package com.personal.fda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.fda.entities.Payment;
import com.personal.fda.services.PaymentService;

@RestController
@RequestMapping("/api/v1/fda/payment")
@ResponseBody
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/addPayment")
	public ResponseEntity<Payment> addPayment(@RequestParam Long orderId){
		Payment payment=this.paymentService.addPayment(orderId);
		return ResponseEntity.ok(payment);
	}
}
