package com.personal.fda.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

	private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendOrderConfirmationMail(
            String toEmail,
            String customerName,
            Long orderId,
            Double totalPrice
    ) {
    	SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("✅ Order Confirmed - FDA");
        message.setText(
                "Hi " + customerName + ",\n\n" +
                "Your order (Order ID: " + orderId + ") has been placed successfully.\n\n" +
                "💰 Total Amount: ₹" + totalPrice + "\n" +
                "⏰ Estimated Delivery Time: 30-40 minutes\n\n" +
                "Thank you for ordering with FDA!\n" +
                "Happy Eating 🍔🍕\n\n" +
                "— FDA Team"
        );

        mailSender.send(message);
    
    }
}
