package com.personal.fda.services;

import java.util.List;

import com.personal.fda.dtos.MenuItemDTO;
import com.personal.fda.dtos.MenuItemOutDTO;
import com.personal.fda.entities.MenuItem;

public interface MenuItemService {

	public MenuItem addMenuItem(Long menuCategoryId,Long restaurantId,Long ownerId,MenuItemDTO menuItemDTO);
	
	public List<MenuItemOutDTO> getItemByCategory(String menuCategoryName);
	
	public List<MenuItemOutDTO> getItemByName(String menuItemName);
}
