package com.hcl.financialspendanalyzerapp.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Customer implements Serializable {

	private static final long serialVersionUID = -8671803081992677318L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private  String name;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "pan")
	private String pan;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;
	
	@Column(name = "customer_id",unique=true, nullable = false)
	private String customerId;
	
	@Column(name = "account_balance")
	private Double accountBalance = 0.0;
	
	@OneToMany(mappedBy= "customerDetails", cascade = CascadeType.ALL)
	private List<Transaction> transactionList;
}
