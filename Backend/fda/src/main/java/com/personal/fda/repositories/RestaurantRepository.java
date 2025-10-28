package com.personal.fda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.fda.entities.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{

}
