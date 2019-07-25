package com.hcl.financialspendanalyzerapp.dto;

import lombok.Data;

@Data
public class MonthlyAggregateSummaryDTO {

	private String month;
	
	private String customerId;
	
	private String totalIncoming;
	
	private String totalOutgoing;
	
	private String closingBalance;
}
