package com.TradeSpot.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor

@Getter
@Setter
public class ProductDTO {

    private String productName;

    private String description;

    private double price;

    private LocalDate addedDate;

    private String productImgPath;
    private boolean isActive;

    public ProductDTO(String productName, String description, double price, LocalDate addedDate, String productImgPath) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.addedDate = addedDate;
        this.productImgPath = productImgPath;
        this.isActive=true;
    }
}
