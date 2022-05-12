package com.group7.creditsservice.repository;

import com.group7.creditsservice.model.Loan;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LoanRepository extends ReactiveMongoRepository<Loan, String> {
}
