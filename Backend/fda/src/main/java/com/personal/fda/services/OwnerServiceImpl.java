package com.personal.fda.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.personal.fda.dtos.OwnerUserDTO;
import com.personal.fda.entities.RestaurantOwner;
import com.personal.fda.entities.Role;
import com.personal.fda.entities.User;
import com.personal.fda.repositories.RestaurantOwnerRepository;
import com.personal.fda.repositories.UserRepository;

@Service
public class OwnerServiceImpl implements OwnerService{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RestaurantOwnerRepository ownerRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public RestaurantOwner createOwner(OwnerUserDTO ownerUserDTO) {
		RestaurantOwner owner=this.modelMapper.map(ownerUserDTO,RestaurantOwner.class);
		User user=this.modelMapper.map(ownerUserDTO,User.class);
		user.setPassword(passwordEncoder.encode(ownerUserDTO.getPassword()));

	    user.setRole(Role.CUSTOMER);

	    owner.setUser(user);

	    userRepository.save(user);
	    return ownerRepository.save(owner);
	}
}
