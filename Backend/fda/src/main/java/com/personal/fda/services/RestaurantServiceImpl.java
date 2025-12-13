package com.personal.fda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.fda.dtos.MenuItemOutDTO;
import com.personal.fda.dtos.RestaurantDTO;
import com.personal.fda.entities.Customer;
import com.personal.fda.entities.Restaurant;
import com.personal.fda.entities.RestaurantOwner;
import com.personal.fda.repositories.CustomerRepository;
import com.personal.fda.repositories.RestaurantOwnerRepository;
import com.personal.fda.repositories.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private RestaurantOwnerRepository ownerRepository;	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Restaurant addRestaurant(Long ownerId,RestaurantDTO restaurantDTO) {
		RestaurantOwner owner=this.ownerRepository.findByRestaurantOwnerId(ownerId);
		Restaurant restaurant=this.modelMapper.map(restaurantDTO,Restaurant.class);
		restaurant.setOwner(owner);
		return this.restaurantRepository.save(restaurant);
	}
	
	public List<RestaurantDTO> getRestaurant(Long customerId){
		Customer customer = customerRepository.getCustomerById(customerId);

	    String location = customer.getAddress();
	    
	    List<Restaurant> restaurants=restaurantRepository.findByRestaurantByLocation(location);
	    
	    return restaurants.stream()
	            .map(restaurant -> {
	            	RestaurantDTO dto = this.modelMapper.map(restaurant, RestaurantDTO.class);
	                return dto;
	            })
	            .collect(Collectors.toList());
	}
	
}
