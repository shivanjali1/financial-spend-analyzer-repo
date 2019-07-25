package com.hcl.financialspendanalyzerapp.service;

import java.util.List;

import com.hcl.financialspendanalyzerapp.dto.MonthlyAggregateSummaryDTO;

public interface AggregateFinanceSummaryService {

	public List<MonthlyAggregateSummaryDTO> getMonthlyAggregateSummary(String customerId);
}
