package com.personal.fda.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.fda.dtos.RestaurantDTO;
import com.personal.fda.entities.Restaurant;
import com.personal.fda.entities.RestaurantOwner;
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
	
	public Restaurant addRestaurant(Long ownerId,RestaurantDTO restaurantDTO) {
		RestaurantOwner owner=this.ownerRepository.findByRestaurantOwnerId(ownerId);
		Restaurant restaurant=this.modelMapper.map(restaurantDTO,Restaurant.class);
		restaurant.setOwner(owner);
		return this.restaurantRepository.save(restaurant);
	}
}
