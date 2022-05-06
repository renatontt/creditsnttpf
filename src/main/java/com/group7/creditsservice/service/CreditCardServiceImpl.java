package com.group7.creditsservice.service;

import com.group7.creditsservice.entity.CreditCard;
import com.group7.creditsservice.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardServiceImpl implements ICreditCardService {

    @Autowired
    private CreditCardRepository repository;

    @Override
    public Mono<CreditCard> saveCreditCard(CreditCard creditCard) {
        return repository.save(creditCard);
    }

    @Override
    public Flux<CreditCard> findAllCreditCars() {
        return repository.findAll().switchIfEmpty(Flux.empty());
    }
}
