package com.hcl.financialspendanalyzerapp.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO  {

	private String errorMessage;
	private HttpStatus httpStatus;
	private Object data;

}
