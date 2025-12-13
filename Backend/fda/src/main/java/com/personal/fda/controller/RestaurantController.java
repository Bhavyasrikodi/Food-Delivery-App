package com.personal.fda.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.fda.dtos.RestaurantDTO;
import com.personal.fda.entities.Restaurant;
import com.personal.fda.services.RestaurantService;

@RestController
@RequestMapping("/api/v1/fda/restaurant")
@ResponseBody
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantDTO> addRestauarnt(@RequestParam Long ownerId,@RequestBody RestaurantDTO restaurantDTO) {
		Restaurant restaurant=this.restaurantService.addRestaurant(ownerId, restaurantDTO);
		RestaurantDTO dto=this.modelMapper.map(restaurant,RestaurantDTO.class);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/getRestaurantsByLocation")
	public ResponseEntity<List<RestaurantDTO>> getRestaurant(@RequestParam Long customerId){
		List<RestaurantDTO> restaurants=this.restaurantService.getRestaurant(customerId);
		return ResponseEntity.ok(restaurants);
	}
}
