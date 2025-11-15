package com.personal.fda.services;

import com.personal.fda.dtos.RestaurantDTO;
import com.personal.fda.entities.Restaurant;

public interface RestaurantService {

	public Restaurant addRestaurant(Long ownerId,RestaurantDTO restaurantDTO);
}
