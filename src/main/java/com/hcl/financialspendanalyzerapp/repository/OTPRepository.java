package com.hcl.financialspendanalyzerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.financialspendanalyzerapp.entity.OtpDetails;

public interface OTPRepository extends JpaRepository<OtpDetails, Long> {

	@Query("from OtpDetails where customerId = :custId and transactionId = :transId")
	OtpDetails getOtpDetailsByTransIdAndCustId(@Param("custId")String custId,@Param("transId") Long tranId);

}
