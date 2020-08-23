package com.infosys.project.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.project.user.entity.CustomerEntity;
import com.infosys.project.user.entity.SellerEntity;
@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, String> {

	SellerEntity findByEmail(String email);

	SellerEntity findByphoneNumber(String phoneNumber);
	

}
