package com.personal.fda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.fda.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long>{

}
