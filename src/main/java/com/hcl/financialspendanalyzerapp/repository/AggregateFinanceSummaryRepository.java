package com.hcl.financialspendanalyzerapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.financialspendanalyzerapp.entity.Transaction;

@Repository
public interface AggregateFinanceSummaryRepository extends JpaRepository<Transaction, Long> {

	@Query(value = "SELECT DATE_FORMAT(date, \"%m-%Y\") month,id, SUM(COALESCE(CASE WHEN payment_type = 'credit' THEN amount END,0)) totalIncoming, SUM(COALESCE(CASE WHEN payment_type = 'debit' THEN amount END,0)) totalOutgoing\r\n" + 
			"       FROM ingfinance.transaction where id = :customerId GROUP BY DATE_FORMAT(date, \"%m-%Y\");",nativeQuery = true)
	public List<List<?>> getMonthlyAggregateSummary(String customerId);
	
}
