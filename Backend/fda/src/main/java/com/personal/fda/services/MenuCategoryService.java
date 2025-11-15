package com.personal.fda.services;

import com.personal.fda.dtos.MenuCategoryDTO;
import com.personal.fda.entities.MenuCategory;

public interface MenuCategoryService {

	public MenuCategory addMenuCategory(Long ownerId,MenuCategoryDTO menuCategoryDTO);
}
