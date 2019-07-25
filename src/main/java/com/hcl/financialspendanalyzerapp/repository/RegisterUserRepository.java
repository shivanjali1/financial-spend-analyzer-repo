package com.hcl.financialspendanalyzerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.financialspendanalyzerapp.entity.Customer;

public interface RegisterUserRepository extends JpaRepository<Customer, Long>{

}
