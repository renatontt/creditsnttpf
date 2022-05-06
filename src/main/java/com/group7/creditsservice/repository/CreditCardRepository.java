package com.group7.creditsservice.repository;

import com.group7.creditsservice.entity.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, String> {
}
