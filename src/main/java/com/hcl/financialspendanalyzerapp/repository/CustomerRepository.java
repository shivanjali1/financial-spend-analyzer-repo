package com.hcl.financialspendanalyzerapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.financialspendanalyzerapp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	//@Query(value = "select id from customer where email =?1",nativeQuery = true)
	Customer findByEmail(String email);
	
	
	Optional<Customer> findByCustomerId(String customerId);
}
