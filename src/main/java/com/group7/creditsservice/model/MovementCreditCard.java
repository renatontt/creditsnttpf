package com.group7.creditsservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

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

