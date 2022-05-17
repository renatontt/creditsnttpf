package com.group7.creditsservice.service;

import com.group7.creditsservice.model.MovementCreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface MovementCreditCardService {

    Flux<MovementCreditCard> getAll();

    Mono<MovementCreditCard> getById(String id);

    Flux<MovementCreditCard> getAllMovementsByCredit(String credit);

    Mono<Double> getStateByCreditPerMonthAndYear(String credit, int year, int month);
    Mono<Double> getAverageDailyBalance(String credit);

    Flux<Map<String, Double>> getAllReportsByClient(String client);

    Mono<MovementCreditCard> save(MovementCreditCard movementRequest);

    Mono<MovementCreditCard> update(String id,MovementCreditCard movementRequest);

    Mono<Void> delete(String id);

    Mono<Void> deleteAll();

}
