package com.personal.fda.services;


import com.personal.fda.dtos.CustomerUserDTO;
import com.personal.fda.entities.Customer;

public interface CustomerService {

	public Customer createCustomer(CustomerUserDTO customerUserDTO);
}
