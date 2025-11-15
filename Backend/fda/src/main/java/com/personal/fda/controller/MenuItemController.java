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

import com.personal.fda.dtos.MenuItemDTO;
import com.personal.fda.entities.MenuItem;
import com.personal.fda.services.MenuItemService;

@RestController
@RequestMapping("/api/v1/fda/menuitem")
@ResponseBody
public class MenuItemController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MenuItemService menuItemService;
	
	@PostMapping("/addMenuItem")
	public ResponseEntity<MenuItemDTO> addMenuItem(@RequestParam Long menuCategoryId,@RequestParam Long restaurantId,@RequestBody MenuItemDTO menuItemDTO){
		MenuItem item=this.menuItemService.addMenuItem(menuCategoryId, restaurantId, menuItemDTO);
		MenuItemDTO dto=this.modelMapper.map(item, MenuItemDTO.class);
		return ResponseEntity.ok(dto);
	}
}
