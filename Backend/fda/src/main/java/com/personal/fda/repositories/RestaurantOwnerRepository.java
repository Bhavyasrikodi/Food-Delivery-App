package com.personal.fda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.fda.entities.RestaurantOwner;

@Repository
public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner,Long>{

}
