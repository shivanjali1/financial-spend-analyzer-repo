package com.hcl.financialspendanalyzerapp.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MonthlyAggregateSummary {

	private LocalDate month;
	
	private String customerId;
	
	private Double totalIncoming;
	
	private Double totalOutgoing;
	
	private Double closingBalance;
}
