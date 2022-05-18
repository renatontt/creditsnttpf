package com.group7.creditsservice.dto;

import com.group7.creditsservice.model.MovementCreditCard;
import com.group7.creditsservice.model.MovementLoan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MovementResponse {
    private String id;
    private String type;
    private Double amount;
    private LocalDate date;
    private String credit;

    public static MovementResponse fromModelMovementCreditCard(MovementCreditCard movementCreditCard) {
        return MovementResponse.builder()
                .id(movementCreditCard.getId())
                .type(movementCreditCard.getType())
                .amount(movementCreditCard.getAmount())
                .date(movementCreditCard.getDate())
                .credit(movementCreditCard.getCredit())
                .build();
    }

    public static MovementResponse fromModelMovementLoan(MovementLoan movementLoan) {
        return MovementResponse.builder()
                .id(movementLoan.getId())
                .type(movementLoan.getType())
                .amount(movementLoan.getAmount())
                .date(movementLoan.getDate())
                .credit(movementLoan.getLoan())
                .build();
    }
}
