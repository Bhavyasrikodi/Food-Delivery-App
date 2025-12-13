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
			+ "mi.restaurant_id=(select r.restaurant_id from restaurant r where r.name=?)",nativeQuery=true)
	MenuItem getItemByNameAndRestaurant(String itemName,String restaurantName);
	
	@Query(value="select m.* from menu_item m where restaurant_id IN\r\n"
			+ "(select restaurant_id from restaurant where location=\r\n"
			+ "(select address from customer where customer_ID=?)) AND m.name=?",nativeQuery=true)
	List<MenuItem> searchItemBasedOnLocation(Long customerId,String itemName);
	
	@Query(value="SELECT mi.* FROM menu_item mi JOIN restaurant r \r\n"
			+ "ON mi.restaurant_id = r.restaurant_id\r\n"
			+ "JOIN customer c ON r.location = c.address\r\n"
			+ "WHERE c.customer_id = ?\r\n"
			+ "AND mi.dietary_info = ?",nativeQuery=true)
	List<MenuItem> filterItemsBasedOnDietaryInfo(Long customerId,String dietaryInfo);
	
	
	@Query(value="sELECT m.*\r\n"
			+ "FROM menu_item m\r\n"
			+ " JOIN restaurant r \r\n"
			+ "ON m.restaurant_id = r.restaurant_id\r\n"
			+ "JOIN customer c ON r.location = c.address\r\n"
			+ "WHERE c.customer_id = ?\r\n"
			+ "and m.name ILIKE  CONCAT('%', ?, '%')",nativeQuery=true)
	List<MenuItem> filterItemsBasedOnItemType(Long customerId,String itemName);
	
	@Query(value="sELECT m.*\r\n"
			+ "FROM menu_item m\r\n"
			+ " JOIN restaurant r \r\n"
			+ "ON m.restaurant_id = r.restaurant_id\r\n"
			+ "JOIN customer c ON r.location = c.address\r\n"
			+ "WHERE c.customer_id = ?\r\n"
			+ "and m.name ILIKE CONCAT('%', ?, '%') and m.dietary_info ILIKE  CONCAT('%', ?, '%')",nativeQuery=true)
	List<MenuItem> filterItemsBasedOnItemAndDietary(Long customerId,String itemName,String dietaryInfo);
	
	
	
}
