package com.group7.creditsservice.service;

import com.group7.creditsservice.dto.CreditCardRequest;
import com.group7.creditsservice.dto.CreditCardResponse;
import com.group7.creditsservice.exception.loan.LoanNotFoundException;
import com.group7.creditsservice.model.CreditCard;
import com.group7.creditsservice.repository.CreditCardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository repository;

    @Override
    public Mono<CreditCardResponse> saveCreditCard(Mono<CreditCardRequest> creditCardRequestMono) {
        return creditCardRequestMono.map(CreditCardRequest::toModel)
                .flatMap(repository::insert)
                .map(CreditCardResponse::fromModel);
    }

    @Override
    public Flux<CreditCard> findAllCreditCars() {
        return repository.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<CreditCardResponse> updateCreditCard(String id, Mono<CreditCardRequest> creditCardRequestMono) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new LoanNotFoundException("Credit card not found with id"+id)))
                .doOnError(ex -> log.error("Credit card not found with id: {}", id, ex))
                .flatMap(creditCard -> creditCardRequestMono.map(CreditCardRequest::toModel))
                .map(CreditCardResponse::fromModel)
                .doOnSuccess(res -> log.info("Updated credit card with id", res.getId()));
    }

    @Override
    public Mono<Void> deleteCreditCard(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new LoanNotFoundException("Credit card not found with id: "+id)))
                .doOnError(ex -> log.error("Credit card found with id: {}", id, ex))
                .flatMap(existing -> repository.delete(existing))
                        .doOnSuccess(ex->log.info("Delete credit card with id {}", id));
    }
}
