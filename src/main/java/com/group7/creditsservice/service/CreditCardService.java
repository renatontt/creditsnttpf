package com.group7.creditsservice.service;

import com.group7.creditsservice.dto.CreditCardRequest;
import com.group7.creditsservice.dto.CreditCardResponse;
import com.group7.creditsservice.model.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {

    public Flux<CreditCard> findAllCreditCars();

    Mono<CreditCardResponse> getById(String id);

    public Flux<CreditCardResponse> getAllCreditCardsByClient(String client);

    public Mono<CreditCardResponse> saveCreditCard(CreditCardRequest creditCardRequestMono);

    Mono<CreditCardResponse> updateCreditCard(String id, Mono<CreditCardRequest> creditCardRequestMono);

    Mono<Void> deleteCreditCard(String id);
}
