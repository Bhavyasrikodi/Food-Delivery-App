package com.personal.fda.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.fda.dtos.CustomerUserDTO;
import com.personal.fda.entities.Customer;
import com.personal.fda.entities.Role;
import com.personal.fda.services.CustomerService;

@RestController
@RequestMapping("/api/auth/v1/fda/customer")
@ResponseBody
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@PostMapping("/createCustomer")
	public ResponseEntity<CustomerUserDTO> creatCustomer( @RequestBody CustomerUserDTO customerUserDTO ) {
		Customer customer=this.customerService.createCustomer(customerUserDTO);
		CustomerUserDTO customerUserDto=this.modelMapper.map(customer,CustomerUserDTO.class);
		
		customerUserDto.setUsername(customerUserDTO.getUsername());
		customerUserDto.setPassword(null);

		customerUserDto.setRole(Role.CUSTOMER);

		return ResponseEntity.ok(customerUserDto);
	}	
	
}
