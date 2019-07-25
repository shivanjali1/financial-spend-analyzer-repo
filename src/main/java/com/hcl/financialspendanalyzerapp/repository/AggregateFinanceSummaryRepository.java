package com.hcl.financialspendanalyzerapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.financialspendanalyzerapp.dto.MonthlyAggregateSummaryDTO;
import com.hcl.financialspendanalyzerapp.entity.Transaction;

@Repository
public interface AggregateFinanceSummaryRepository extends JpaRepository<Transaction, Long> {

	public List<MonthlyAggregateSummaryDTO> getMonthlyAggregateSummary(String customerId);
}
