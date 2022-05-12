package com.group7.creditsservice.controller;

import com.group7.creditsservice.dto.LoanRequest;
import com.group7.creditsservice.dto.LoanResponse;
import com.group7.creditsservice.model.Loan;
import com.group7.creditsservice.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/credits/loans")

public class LoanController {
    @Autowired
    private ILoanService service;

    @GetMapping
    public Flux<Loan> getLoans() {
        return service.findAllLoans();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<LoanResponse> saveLoan(@Valid @RequestBody Mono<LoanRequest> loanRequest) {
        return service.saveLoan(loanRequest);
    }
}
