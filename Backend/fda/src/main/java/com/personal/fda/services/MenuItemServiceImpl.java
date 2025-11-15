package com.personal.fda.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.fda.dtos.MenuItemDTO;
import com.personal.fda.entities.MenuCategory;
import com.personal.fda.entities.MenuItem;
import com.personal.fda.entities.Restaurant;
import com.personal.fda.repositories.MenuCategoryRepository;
import com.personal.fda.repositories.MenuItemRepository;
import com.personal.fda.repositories.RestaurantRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	@Autowired
	private MenuCategoryRepository menuCategoryRepository;
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public MenuItem addMenuItem(Long menuCategoryId,Long restaurantId,MenuItemDTO menuItemDTO) {
		MenuCategory menuCategory=this.menuCategoryRepository.findByMenuCategoryId(menuCategoryId);
		Restaurant restaurant=this.restaurantRepository.findByRestaurantId(restaurantId);
		MenuItem item=this.modelMapper.map(menuItemDTO, MenuItem.class);
		item.setCategory(menuCategory);
		item.setRestaurant(restaurant);
		return this.menuItemRepository.save(item);
	}
}
