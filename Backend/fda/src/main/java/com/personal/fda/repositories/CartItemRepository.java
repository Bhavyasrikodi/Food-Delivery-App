package com.personal.fda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.personal.fda.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long>{

	@Query(value="select * from cart_item where customer_id=?",nativeQuery=true)
	List<CartItem> cartItemsByCustomerId(Long customerId);
}
