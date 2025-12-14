package com.personal.fda.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.personal.fda.dtos.CustomerUserDTO;
import com.personal.fda.entities.Customer;
import com.personal.fda.entities.Role;
import com.personal.fda.entities.User;
import com.personal.fda.repositories.CustomerRepository;
import com.personal.fda.repositories.UserRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Customer createCustomer(CustomerUserDTO customerUserDTO) {
		Customer customer=this.modelMapper.map(customerUserDTO,Customer.class);
		User user=this.modelMapper.map(customerUserDTO, User.class);
		user.setPassword(passwordEncoder.encode(customerUserDTO.getPassword()));

	    user.setRole(Role.CUSTOMER);

	    customer.setUser(user);

	    userRepository.save(user);
	    return customerRepository.save(customer);
	}

}
