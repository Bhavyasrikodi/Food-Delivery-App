package com.personal.fda.services;

import com.personal.fda.dtos.MenuItemDTO;
import com.personal.fda.entities.MenuItem;

public interface MenuItemService {

	public MenuItem addMenuItem(Long menuCategoryId,Long restaurantId,MenuItemDTO menuItemDTO);
}
