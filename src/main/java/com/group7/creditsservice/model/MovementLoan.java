package com.group7.creditsservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movementsLoans")
public class MovementLoan extends Movement {
    @NonNull
    private String loan;
}
