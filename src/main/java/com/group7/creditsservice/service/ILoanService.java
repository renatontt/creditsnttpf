package com.group7.creditsservice.service;

import com.group7.creditsservice.dto.LoanRequest;
import com.group7.creditsservice.dto.LoanResponse;
import com.group7.creditsservice.model.Loan;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ILoanService {

    public Mono<LoanResponse> saveLoan(Mono<LoanRequest> loanRequest);

    public Flux<Loan> findAllLoans();
}
