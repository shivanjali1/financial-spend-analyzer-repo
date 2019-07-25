package com.hcl.financialspendanalyzerapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.financialspendanalyzerapp.dto.MonthlyAggregateSummaryDTO;

@Service
public interface AggregateFinanceSummaryService {

	public List<MonthlyAggregateSummaryDTO> getMonthlyAggregateSummary(String customerId);
}
