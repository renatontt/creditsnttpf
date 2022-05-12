package com.group7.creditsservice.service;

import com.group7.creditsservice.model.MovementCreditCard;
import com.group7.creditsservice.exception.movement.MovementCreationException;
import com.group7.creditsservice.repository.CreditCardRepository;
import com.group7.creditsservice.repository.MovementCreditCardRepository;
import com.group7.creditsservice.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;

@Service
@AllArgsConstructor
@Slf4j
public class MovementCreditCardServiceImpl implements IMovementCreditCardService {
    private MovementCreditCardRepository movementRepository;

    private CreditCardRepository creditCardRepository;

    @Override
    public Flux<MovementCreditCard> getAll() {
        return movementRepository.findAll();
    }

    @Override
    public Mono<MovementCreditCard> getById(String id) {
        return movementRepository.findById(id)
                .switchIfEmpty(Mono.error(new MovementCreationException("Movement not found with id: " + id)));
    }

    @Override
    public Flux<MovementCreditCard> getAllMovementsByCredit(String credit) {
        return movementRepository.findByCredit(credit);
    }

    @Override
    public Mono<Double> getStateByCreditPerMonthAndYear(String credit, int year, int month) {

        YearMonth currentMonth = YearMonth.of(year, month);
        LocalDate firstOfMonth = currentMonth.atDay(1);
        LocalDate last = currentMonth.atEndOfMonth();

        return movementRepository.findByCreditAndDateBetween(credit, DateUtils.asDate(firstOfMonth), DateUtils.asDate(last))
                .doOnEach(System.out::println)
                .reduce(0.0,(x,y)-> x + y.getAmountSigned());

    }

    @Override
    public Mono<Void> delete(String id) {
        return movementRepository.findById(id)
                .switchIfEmpty(Mono.error(new MovementCreationException("Movement not found with id: " + id)))
                .flatMap(existingAccount ->
                        movementRepository.delete(existingAccount)
                );
    }

    @Override
    public Mono<Void> deleteAll() {
        return movementRepository.deleteAll();
    }


    @Override
    public Mono<MovementCreditCard> save(MovementCreditCard movementRequest) {
        return Mono.just(movementRequest)
                .flatMap(movement -> creditCardRepository.findById(movement.getCredit())
                        .switchIfEmpty(Mono.error(new MovementCreationException("Account not found with id: " + movement.getCredit())))
                        .flatMap(existingCredit -> {
                            if (!existingCredit.isMovementValid(movement.getType(), movement.getAmount()))
                                return Mono.error(new MovementCreationException("You reach the limit of your credit card"));
                            existingCredit.makeMovement(movement.getType(), movement.getAmount());
                            return creditCardRepository.save(existingCredit);
                        }))
                .then(Mono.just(movementRequest))
                .map(movement -> {
                    movement.setDate(new Date());
                    return movement;
                })
                .flatMap(movement -> movementRepository.insert(movement))
                .onErrorMap(ex -> new MovementCreationException(ex.getMessage()));
    }

    @Override
    public Mono<MovementCreditCard> update(String id, MovementCreditCard movementRequest) {

        return movementRepository.findById(id)
                .switchIfEmpty(Mono.error(new MovementCreationException("Credit not found with id: " + id)))
                .doOnError(ex -> log.error("Account not found with id: {}", id, ex))
                .flatMap(existingAccount -> {
                    existingAccount.setDate(movementRequest.getDate());
                    return movementRepository.save(existingAccount);
                })
                .doOnSuccess(res -> log.info("Updated movement with ID: {}", res.getId()));

    }
}
