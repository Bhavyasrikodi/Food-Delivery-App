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

import com.personal.fda.dtos.MenuItemDTO;
import com.personal.fda.dtos.MenuItemOutDTO;
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
	public ResponseEntity<MenuItemDTO> addMenuItem(@RequestParam Long menuCategoryId,@RequestParam Long restaurantId,@RequestParam Long ownerId,@RequestBody MenuItemDTO menuItemDTO){
		MenuItem item=this.menuItemService.addMenuItem(menuCategoryId, restaurantId,ownerId, menuItemDTO);
		MenuItemDTO dto=this.modelMapper.map(item, MenuItemDTO.class);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/getMenuItemsByCategory")
	public ResponseEntity<List<MenuItemOutDTO>> getItemsByCategory(@RequestParam String menuCategoryName){
		List<MenuItemOutDTO> items=this.menuItemService.getItemByCategory(menuCategoryName);
		return ResponseEntity.ok(items);
	}
	
	@GetMapping("/getMenuItemsByName")
	public ResponseEntity<List<MenuItemOutDTO>> getItemsByName(@RequestParam String menuItemName){
		List<MenuItemOutDTO> items=this.menuItemService.getItemByName(menuItemName);
		return ResponseEntity.ok(items);
	}
}
