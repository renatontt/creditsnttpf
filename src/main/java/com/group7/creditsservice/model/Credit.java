package com.group7.creditsservice.model;

import com.group7.creditsservice.exception.movement.MovementCreationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Credit {
    @Id
    private String id;

    private String client;
    private double amount;
    private int paymentDay;
    private double tcea;
    private double balance;

    public boolean isMovementValid(String type, Double amount) {

        if (Objects.isNull(type) || Objects.isNull(amount))
            throw new MovementCreationException("Type, Account and Amount are mandatory attributes");

        return !type.equalsIgnoreCase("withdraw") ||
                balance >= amount;
    }

    public void makeMovement(String type, Double amount) {
        if (type.equalsIgnoreCase("withdraw")) {
            balance -= amount;
        } else if (type.equalsIgnoreCase("deposit")) {
            balance += amount;
        }
    }
}
