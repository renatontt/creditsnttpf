package com.group7.creditsservice.repository;

import com.group7.creditsservice.entity.Loan;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LoanRepository extends ReactiveMongoRepository<Loan, String> {
}
