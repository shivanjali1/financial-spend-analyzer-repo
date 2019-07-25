package com.hcl.financialspendanalyzerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.financialspendanalyzerapp.entity.Customer;

public interface RegisterUserRepository extends JpaRepository<Customer, Long>{

	@Query(value = "select id from customer where email =?1",nativeQuery = true)
	String findByEmail(String email);

}
