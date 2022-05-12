package com.group7.creditsservice.service;

import com.group7.creditsservice.model.MovementLoan;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovementLoanService {
    Flux<MovementLoan> getAll();

    Mono<MovementLoan> getById(String id);

    Flux<MovementLoan> getAllMovementsByLoan(String loan);

    Mono<Double> getStateByLoanPerMonthAndYear(String loan, int year, int month);

    Mono<Void> delete(String id);

    Mono<Void> deleteAll();

    Mono<MovementLoan> save(MovementLoan movementLoan);

    Mono<MovementLoan> update(String id, MovementLoan movementLoan);

}
