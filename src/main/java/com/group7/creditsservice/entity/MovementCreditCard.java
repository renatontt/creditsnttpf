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
public class MovementCreditCard extends Movement {

    @NonNull
    private String credit;
}

