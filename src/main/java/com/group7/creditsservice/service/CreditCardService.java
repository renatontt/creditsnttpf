package com.group7.creditsservice.service;

import com.group7.creditsservice.model.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {

    public Mono<CreditCard> saveCreditCard(CreditCard creditCard);

    public Flux<CreditCard> findAllCreditCars();
}
