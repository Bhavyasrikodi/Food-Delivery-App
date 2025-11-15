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

import com.personal.fda.dtos.MenuCategoryDTO;
import com.personal.fda.entities.MenuCategory;
import com.personal.fda.services.MenuCategoryService;

@RestController
@RequestMapping("/api/v1/fda/menucategory")
@ResponseBody
public class MenuCategoryController {

	@Autowired
	private MenuCategoryService menuCategoryService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/addMenuCategory")
	public ResponseEntity<MenuCategoryDTO> addMenuCategory(@RequestParam Long ownerId,@RequestBody MenuCategoryDTO menuCategoryDTO) {
		MenuCategory category=this.menuCategoryService.addMenuCategory(ownerId,menuCategoryDTO);
		MenuCategoryDTO categoryDTO=this.modelMapper.map(category, MenuCategoryDTO.class);
		categoryDTO.setName(menuCategoryDTO.getName());
		return ResponseEntity.ok(categoryDTO);
		
	}
}
