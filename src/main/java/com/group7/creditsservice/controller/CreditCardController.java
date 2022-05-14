package com.group7.creditsservice.controller;

import com.group7.creditsservice.dto.CreditCardRequest;
import com.group7.creditsservice.dto.CreditCardResponse;
import com.group7.creditsservice.dto.LoanRequest;
import com.group7.creditsservice.model.CreditCard;
import com.group7.creditsservice.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/credits/credit_cards")

public class CreditCardController {
    @Autowired
    private CreditCardService service;

    @GetMapping
    public Flux<CreditCard> getCreditCards() {
        return service.findAllCreditCars();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CreditCardResponse> saveCreditCard(@Valid @RequestBody Mono<CreditCardRequest> creditCardRequestMono) {
        return service.saveCreditCard(creditCardRequestMono);
    }

    @PutMapping("{id}")
    public Mono<CreditCardResponse> updateCreditCard(@PathVariable String id, @Valid @RequestBody Mono<CreditCardRequest> creditCardRequestMono) {
        return service.updateCreditCard(id, creditCardRequestMono);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteCreditCard(@PathVariable String id) {
        return service.deleteCreditCard(id);
    }
}
