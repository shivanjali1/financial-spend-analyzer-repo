package com.hcl.financialspendanalyzerapp.serviceimpl;

import java.util.ArrayList;
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

		List<List<?>> monthlyAggregateSummary = null;
		MonthlyAggregateSummaryDTO monthlyAggregateSummaryDTO = null;
		List<MonthlyAggregateSummaryDTO> monthlyAggregateSummaryDTOs = new ArrayList<MonthlyAggregateSummaryDTO>();
		monthlyAggregateSummary = aggregateFinanceSummaryRepository.getMonthlyAggregateSummary(customerId);

		for (List<?> objs : monthlyAggregateSummary) {
			monthlyAggregateSummaryDTO = new MonthlyAggregateSummaryDTO();
			monthlyAggregateSummaryDTO.setMonth(String.valueOf(objs.get(0)));
			monthlyAggregateSummaryDTO.setCustomerId(String.valueOf(objs.get(1)));
			monthlyAggregateSummaryDTO.setTotalIncoming(String.valueOf(objs.get(2)));
			monthlyAggregateSummaryDTO.setTotalOutgoing(String.valueOf(objs.get(3)));
			monthlyAggregateSummaryDTOs.add(monthlyAggregateSummaryDTO);
		}

		return monthlyAggregateSummaryDTOs;
	}

}
