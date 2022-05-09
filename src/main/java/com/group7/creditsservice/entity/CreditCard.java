package com.group7.creditsservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.group7.creditsservice.exception.movement.MovementCreationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cardcredits")

public class CreditCard extends Credit {
    private String number;
    private double balance;

    private LocalDateTime billingDay;

    public boolean isMovementValid(String type, Double amount) {

        if (Objects.isNull(type) || Objects.isNull(amount))
            throw new MovementCreationException("Type, Account and Amount are mandatory attributes");

        return !type.equalsIgnoreCase("expense") ||
                balance >= amount;
    }

    public void makeMovement(String type, Double amount) {
        if (type.equalsIgnoreCase("expense")) {
            balance -= amount;
        } else if (type.equalsIgnoreCase("payment")) {
            balance += amount;
        }
    }
}
