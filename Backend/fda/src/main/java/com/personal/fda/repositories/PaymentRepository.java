package com.personal.fda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.fda.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>{

}
