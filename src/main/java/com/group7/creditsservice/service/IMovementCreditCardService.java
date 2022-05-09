package com.group7.creditsservice.service;

import com.group7.creditsservice.entity.MovementCreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovementCreditCardService {

    Flux<MovementCreditCard> getAll();

    Mono<MovementCreditCard> getById(String id);

    Flux<MovementCreditCard> getAllMovementsByCredit(String credit);

    Mono<Double> getStateByCreditPerMonthAndYear(String credit, int year, int month);

    Mono<Void> delete(String id);

    Mono<Void> deleteAll();

    Mono<MovementCreditCard> save(MovementCreditCard movementRequest);

    Mono<MovementCreditCard> update(String id,MovementCreditCard movementRequest);

}
