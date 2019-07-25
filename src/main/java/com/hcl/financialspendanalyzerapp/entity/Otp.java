package com.hcl.financialspendanalyzerapp.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "opt_id")
public class Otp implements Serializable {
	
	private static final long serialVersionUID = -8985679445647579333L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "opt_id")
	private  Long optId;
	
	private String customerId;
	
	@Column(name = "time")
	private LocalDateTime time;
	
	@Column(name = "oTP")
	private String oTP;
	
	@Column(name = "transaction_id")
	private Long transactionId;

}
