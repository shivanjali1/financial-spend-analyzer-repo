package com.hcl.financialspendanalyzerapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.financialspendanalyzerapp.dto.MonthlyAggregateSummaryDTO;
import com.hcl.financialspendanalyzerapp.repository.AggregateFinanceSummaryRepository;
import com.hcl.financialspendanalyzerapp.service.AggregateFinanceSummaryService;

@Service
public class AggregateFinanceSummaryServiceImpl implements AggregateFinanceSummaryService {

	@Autowired
	AggregateFinanceSummaryRepository aggregateFinanceSummaryRepository;
	
	@Override
	public List<MonthlyAggregateSummaryDTO> getMonthlyAggregateSummary(String customerId) {

		List<MonthlyAggregateSummaryDTO> monthlyAggregateSummary = null;
		//monthlyAggregateSummary = aggregateFinanceSummaryRepository.getMonthlyAggregateSummary(customerId);
		return monthlyAggregateSummary;
	}

}
