package com.personal.fda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.personal.fda.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

	@Query(value="select * from customer where customer_id=?",nativeQuery=true)
	Customer getCustomerById(Long customerId);
}
