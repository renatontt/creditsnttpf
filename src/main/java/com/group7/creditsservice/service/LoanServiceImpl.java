package com.group7.creditsservice.service;

import com.group7.creditsservice.entity.Loan;
import com.group7.creditsservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanServiceImpl implements ILoanService {
    @Autowired
    private LoanRepository repository;

    @Override
    public Mono<Loan> saveLoan(Loan loan) {
        return repository.save(loan);
    }

    @Override
    public Flux<Loan> findAllLoans() {
        return repository.findAll();
    }
}
