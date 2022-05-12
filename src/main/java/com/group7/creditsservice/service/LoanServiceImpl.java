package com.group7.creditsservice.service;

import com.group7.creditsservice.dto.LoanRequest;
import com.group7.creditsservice.dto.LoanResponse;
import com.group7.creditsservice.model.Loan;
import com.group7.creditsservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanServiceImpl implements ILoanService {
    @Autowired
    private LoanRepository repository;

//    @Override
//    public Mono<LoanResponse> saveLoan(LoanRequest loanRequest) {
//        return repository.save(loanRequest);
//    }

    @Override
    public Mono<LoanResponse> saveLoan(Mono<LoanRequest> loanRequest) {
        return loanRequest.map(LoanRequest::toModel)
                .flatMap(repository::insert)
                .map(LoanResponse::fromModel);
    }

    @Override
    public Flux<Loan> findAllLoans() {
        return repository.findAll();
    }
}
