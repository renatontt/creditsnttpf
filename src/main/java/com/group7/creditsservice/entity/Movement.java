package com.group7.creditsservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class Movement {
    @Id
    private String id;
    @NonNull
    private String type;
    @NonNull
    private Double amount;
    private Date date;

    public Double getAmountSigned(){
        return type.equalsIgnoreCase("withdraw")?-1*amount:amount;
    }
}
