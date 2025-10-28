package com.personal.fda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.fda.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{

}
