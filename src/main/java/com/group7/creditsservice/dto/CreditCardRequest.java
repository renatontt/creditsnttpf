package com.group7.creditsservice.dto;

import com.group7.creditsservice.model.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreditCardRequest {
    private String id;

    @NotBlank
    private String client;

    @Positive
    @NotNull
    private double amount;

    @Positive
    @NotNull
    private double balance;

    @NotNull
    @Min(value = 1)
    @Max(value = 25)
    private int paymentDay;

    @NotBlank
    private String number;

    @NotNull
    @Min(value = 1)
    @Max(value = 25)
    private int billingDay;

    public CreditCard toModel() {
        return CreditCard.builder()
                .client(this.client)
                .amount(this.amount)
                .balance(this.balance)
                .paymentDay(this.paymentDay)
                .number(this.number)
                .billingDay(this.billingDay)
                .build();
    }
}
