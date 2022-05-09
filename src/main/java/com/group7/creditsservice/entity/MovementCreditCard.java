package com.group7.creditsservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Document(collection="movementsCreditCard")
public class MovementCreditCard {
    @Id
    private String id;
    @NonNull
    private String type;
    @NonNull
    private Double amount;
    private Date date;
    @NonNull
    private String credit;

    public Double getAmountSigned(){
        return type.equalsIgnoreCase("expense")?-1*amount:amount;
    }
}
