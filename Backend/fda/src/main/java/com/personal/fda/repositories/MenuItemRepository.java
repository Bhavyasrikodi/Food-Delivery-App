package com.personal.fda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.personal.fda.entities.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Long>{

	@Query(value="select mi.* from menu_Item mi where mi.category_id=\r\n"
			+ "(select mc.menu_category_id from menu_category mc where mc.name=?)",nativeQuery=true)
	List<MenuItem>getItemsByCategory(String categoryName);
	
	@Query(value="select mi.* from menu_Item mi where mi.name=?",nativeQuery=true)
	List<MenuItem>getItemsByItemName(String itemName);
	
	
	@Query(value="select mi.* from menu_Item mi where mi.name=? and \r\n"
			+ "mi.restaurant_id=(select r.restaurant_id from restaurant r where r.name=?);",nativeQuery=true)
	MenuItem getItemByNameAndRestaurant(String itemName,String restaurantName);
	
}
