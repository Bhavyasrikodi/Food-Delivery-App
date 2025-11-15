package com.personal.fda.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.fda.dtos.MenuCategoryDTO;
import com.personal.fda.entities.MenuCategory;
import com.personal.fda.repositories.MenuCategoryRepository;

@Service
public class MenuCategoryServiceImpl implements MenuCategoryService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MenuCategoryRepository menuCategoryRepository;
	
	public MenuCategory addMenuCategory(Long ownerId,MenuCategoryDTO menuCategoryDTO) {
		MenuCategory category=this.modelMapper.map(menuCategoryDTO,MenuCategory.class);
		System.out.println(menuCategoryDTO.getName());
		category.setName(menuCategoryDTO.getName());
		return this.menuCategoryRepository.save(category);
	}
	
}
