package com.personal.fda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.personal.fda.entities.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{
	Restaurant findByRestaurantId(Long restaurantId);
	
	@Query(value="select * from restaurant where location=?",nativeQuery=true)
	List<Restaurant> findByRestaurantByLocation(String location);
}
