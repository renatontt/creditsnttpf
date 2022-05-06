package com.group7.creditsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Credit {
    @Id
    private String id;
    private String clientId;
    private double amount;
    private int paymentDay;
    private double tea;
}
