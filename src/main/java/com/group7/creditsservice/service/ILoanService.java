package com.group7.creditsservice.service;

import com.group7.creditsservice.entity.Loan;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ILoanService {

    public Mono<Loan> saveLoan(Loan loan);

    public Flux<Loan> findAllLoans();
}
