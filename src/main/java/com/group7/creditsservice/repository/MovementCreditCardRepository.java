package com.group7.creditsservice.repository;

import com.group7.creditsservice.model.MovementCreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.Date;

public interface MovementCreditCardRepository extends ReactiveMongoRepository<MovementCreditCard,String> {

    Flux<MovementCreditCard> findByCredit(String account);

    Flux<MovementCreditCard> findByCreditAndDateBetween(String credit, Date from, Date to);

}
