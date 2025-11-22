package com.personal.fda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.fda.dtos.MenuItemDTO;
import com.personal.fda.dtos.MenuItemOutDTO;
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
	
	public MenuItem addMenuItem(Long menuCategoryId,Long restaurantId,Long ownerId,MenuItemDTO menuItemDTO) {
		MenuCategory menuCategory=this.menuCategoryRepository.findByMenuCategoryId(menuCategoryId);
		Restaurant restaurant=this.restaurantRepository.findByRestaurantId(restaurantId);
		MenuItem item=this.modelMapper.map(menuItemDTO, MenuItem.class);
		item.setCategory(menuCategory);
		item.setRestaurant(restaurant);
		return this.menuItemRepository.save(item);
	}
	
	public List<MenuItemOutDTO> getItemByCategory(String menuCategoryName) {
	    List<MenuItem> items = this.menuItemRepository.getItemsByCategory(menuCategoryName);

	    return items.stream()
	            .map(item -> {
	                MenuItemOutDTO dto = this.modelMapper.map(item, MenuItemOutDTO.class);

	                Restaurant restaurant = item.getRestaurant();
	                if (restaurant != null) {
	                    dto.setRestaurantName(restaurant.getName());
	                }

	                return dto;
	            })
	            .collect(Collectors.toList());
	}

	
	public List<MenuItemOutDTO> getItemByName(String menuItemName){
		List<MenuItem> items=this.menuItemRepository.getItemsByItemName(menuItemName);
		return items.stream()
	            .map(item -> {
	                MenuItemOutDTO dto = this.modelMapper.map(item, MenuItemOutDTO.class);

	                Restaurant restaurant = item.getRestaurant();
	                if (restaurant != null) {
	                    dto.setRestaurantName(restaurant.getName());
	                }

	                return dto;
	            })
	            .collect(Collectors.toList());
	}

	
}
