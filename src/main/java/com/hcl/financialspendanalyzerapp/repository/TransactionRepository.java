package com.hcl.financialspendanalyzerapp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.financialspendanalyzerapp.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	@Query(value="select * from transaction where id = :id and status='completed'", nativeQuery= true)
	public List<Transaction> findTransactionDetails(Long id,Pageable page);
	
	public Transaction findByTransactionIdAndStatusIgnoreCase(Long transactionId, String status);
	
	
}
