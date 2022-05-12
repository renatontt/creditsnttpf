package com.group7.creditsservice.dto;

import com.group7.creditsservice.model.Loan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j

public class LoanRequest {
    private String id;

    @NotBlank
    private String client;

    @Positive
    @NotNull
    private double amount;
    @NotNull
    private int paymentDay;

    @NotNull
    private double fullPayments;
    @NotNull
    private int numberInstallments;


    public Loan toModel() {
        return Loan.builder()
                .client(this.client)
                .amount(this.amount)
                .paymentDay(this.paymentDay)
                .fullPayment(this.fullPayments)
                .numberInstallments(this.numberInstallments)
                .build();
    }
}
