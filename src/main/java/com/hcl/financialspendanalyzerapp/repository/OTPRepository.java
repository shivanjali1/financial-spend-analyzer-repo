package com.hcl.financialspendanalyzerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.financialspendanalyzerapp.entity.OtpDetails;

public interface OTPRepository extends JpaRepository<OtpDetails, Long> {

}
