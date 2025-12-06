package com.personal.fda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Payment {

	 	@Id @GeneratedValue
	    private Long paymentId;
	 
	 	@OneToOne
	    private Order order;
	 	

		public Payment() {
			super();
		}

		
		public Payment(Long paymentId, Order order) {
			super();
			this.paymentId = paymentId;
			this.order = order;
		}


		public Long getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(Long paymentId) {
			this.paymentId = paymentId;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}


		@Override
		public String toString() {
			return "Payment [paymentId=" + paymentId + ", order=" + order + "]";
		}
	 	
}
