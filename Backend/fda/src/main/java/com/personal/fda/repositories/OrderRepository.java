package com.personal.fda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.fda.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{

}
