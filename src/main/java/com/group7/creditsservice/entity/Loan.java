package com.group7.creditsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "loans")

public class Loan extends Credit {
    private double fullPayment;
    private int numberInstallments;
}
