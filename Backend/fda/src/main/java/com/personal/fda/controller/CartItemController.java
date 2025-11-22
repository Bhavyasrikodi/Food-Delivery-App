package com.personal.fda.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.fda.dtos.CartItemDTO;
import com.personal.fda.entities.CartItem;
import com.personal.fda.services.CartItemService;

@RestController
@RequestMapping("/api/v1/fda/cartItem")
@ResponseBody
public class CartItemController {

	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@PostMapping("/addToCart")
	public ResponseEntity<CartItemDTO> addToCart(@RequestParam Long customerId,@RequestBody CartItemDTO cartItemDTO){
		CartItem item=this.cartItemService.addToCart(customerId, cartItemDTO);
		CartItemDTO dto=this.modelMapper.map(item, CartItemDTO.class);
		dto.setRestaurantName(cartItemDTO.getRestaurantName());
		return ResponseEntity.ok(dto);
	}
}
