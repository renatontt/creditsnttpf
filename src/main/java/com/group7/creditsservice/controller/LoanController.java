package com.group7.creditsservice.controller;

import com.group7.creditsservice.entity.Loan;
import com.group7.creditsservice.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Mono<Loan> saveLoan(@RequestBody Loan loan) {
        return service.saveLoan(loan);
    }
}
