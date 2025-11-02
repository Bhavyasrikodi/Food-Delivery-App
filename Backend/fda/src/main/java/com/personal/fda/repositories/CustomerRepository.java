package com.personal.fda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.fda.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
