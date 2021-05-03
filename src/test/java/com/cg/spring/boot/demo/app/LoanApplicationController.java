package com.cg.spring.boot.demo.app;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanApplicationController {

	@Autowired
	ILoanApplicationService loanapplicationservice;

	@GetMapping("/LoanApplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<List<LoanApplication>>(loanapplicationservice.retrieveAllLoanApplication(),
				HttpStatus.OK);
	}

	@GetMapping("/LoanApplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> getLoanApplication(@PathVariable("loanApplicationId") int loanApplicationId)
			throws Exception {
		return new ResponseEntity<LoanApplication>(
				loanapplicationservice.retrieveLoanApplicationById(loanApplicationId), HttpStatus.OK);
	}

	@PostMapping("/addLoanApplication")
	public ResponseEntity<LoanApplication> addLoanApplication(@RequestBody LoanApplication loanApplication) {
		return new ResponseEntity<LoanApplication>(loanapplicationservice.addLoanApplication(loanApplication),
				HttpStatus.OK);
	}

	@PutMapping("/updateLoanApplication")
	public ResponseEntity<LoanApplication> updateLoanApplication(@PathVariable int loanApplicationId,
			@RequestBody LoanApplication loanApplication) throws Exception {
		return new ResponseEntity<LoanApplication>(
				loanapplicationservice.updateLoanApplication(loanApplicationId, loanApplication), HttpStatus.OK);
	}

	@DeleteMapping("/deleteLoanApplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> deleteLoanApplication(@PathVariable int loanApplicationId) throws Exception {
		return new ResponseEntity<LoanApplication>(loanapplicationservice.addLoanApplication(loanApplicationId),
				HttpStatus.OK);
	}
}
