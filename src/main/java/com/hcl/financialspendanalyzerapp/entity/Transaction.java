package com.hcl.financialspendanalyzerapp.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "transactionId")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 8150969107241434435L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_Id")
	private Long transactionId;
	
	@Column(name = "trans_description")
	private String transDescription;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "payment_type")
	private String paymentType;
	
	@Column(name = "date")
	private LocalDateTime date;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Customer customerDetails;
	
	@Column(name = "current_balance")
	private Double currentBalance;
	
}
