package com.group7.creditsservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString
@SuperBuilder
public class Movement {
    @Id
    private String id;
    @NonNull
    private String type;
    @NonNull
    private Double amount;
    private LocalDate date;

    public Double getAmountSigned(){
        return type.equalsIgnoreCase("withdraw")?-1*amount:amount;
    }

    public int getDayOfMovement() {
        return date.getDayOfMonth();
    }
}
