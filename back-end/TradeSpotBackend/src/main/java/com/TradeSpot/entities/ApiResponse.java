package com.TradeSpot.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ApiResponse {

    private String massage;
    private LocalDate date;



    public ApiResponse(String massage) {
        this.massage = massage;
        this.date=LocalDate.now();
    }
}
