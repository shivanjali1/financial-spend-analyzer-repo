package com.hcl.financialspendanalyzerapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.financialspendanalyzerapp.dto.MonthlyAggregateSummaryDTO;
import com.hcl.financialspendanalyzerapp.service.AggregateFinanceSummaryService;

@RestController
@RequestMapping("/summary")
@CrossOrigin
public class AggregateFinanceSummaryController {

	@Autowired
	AggregateFinanceSummaryService aggregateFinanceSummaryService;
	
	@GetMapping()
	public ResponseEntity<Object> getMonthlyAggregateFinancialSummary(@RequestParam("customerId") String customerId){
		
		List<MonthlyAggregateSummaryDTO> monthlyAggregateSummary = null;
		if(null == customerId || " ".equals(customerId))
			throw new ApplicationContextException("Please enter valid customer ID.");
		monthlyAggregateSummary = aggregateFinanceSummaryService.getMonthlyAggregateSummary(customerId);
		return new ResponseEntity<>(monthlyAggregateSummary, HttpStatus.FOUND);
	}
	
}
