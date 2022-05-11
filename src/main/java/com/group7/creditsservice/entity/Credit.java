package com.group7.creditsservice.entity;

import com.group7.creditsservice.exception.movement.MovementCreationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Credit {
    @Id
    private String id;

    private String clientId;
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
