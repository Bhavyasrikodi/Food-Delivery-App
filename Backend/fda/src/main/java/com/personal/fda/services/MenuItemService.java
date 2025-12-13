package com.personal.fda.services;

import java.util.List;

import com.personal.fda.dtos.MenuItemDTO;
import com.personal.fda.dtos.MenuItemOutDTO;
import com.personal.fda.entities.MenuItem;

public interface MenuItemService {

	public MenuItem addMenuItem(Long menuCategoryId,Long restaurantId,Long ownerId,MenuItemDTO menuItemDTO);
	
	public List<MenuItemOutDTO> getItemByCategory(String menuCategoryName);
	
	public List<MenuItemOutDTO> getItemByName(String menuItemName);
	
	public List<MenuItemOutDTO> getItemByNameBasedOnLocation(String menuItemName,Long customerId);
	
	public List<MenuItemOutDTO> filterItemsByDietaryInfo(Long customerId,String dietaryInfo);
	
	public List<MenuItemOutDTO> filterItemsBasedOnItemType(Long customerId,String itemName);
	
	public List<MenuItemOutDTO> filterItemsBasedOnItemTypeAndDietaryInfo(Long customerId,String itemName,String dietaryInfo);
}
