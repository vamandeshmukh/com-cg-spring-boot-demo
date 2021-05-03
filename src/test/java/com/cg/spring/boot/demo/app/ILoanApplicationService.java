package com.cg.spring.boot.demo.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoanApplicationService extends JpaRepository<LoanApplication, Integer> {

	List<LoanApplication> retrieveAllLoanApplication();

	LoanApplication retrieveLoanApplicationById(int loanApplicationId);

	LoanApplication addLoanApplication(LoanApplication loanApplication);

	LoanApplication updateLoanApplication(int loanApplicationId, LoanApplication loanApplication);

	LoanApplication addLoanApplication(int loanApplicationId);

}
