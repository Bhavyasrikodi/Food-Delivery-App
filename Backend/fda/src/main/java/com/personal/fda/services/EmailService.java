package com.personal.fda.services;

public interface EmailService {


public void sendOrderConfirmationMail(
        String toEmail,
        String customerName,
        Long orderId,
        Double totalPrice
) ;

}