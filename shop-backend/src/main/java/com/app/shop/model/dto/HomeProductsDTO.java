package com.app.shop.model.dto;

import lombok.Data;

@Data
public class HomeProductsDTO {

    private String imageUrl;

    private String imageDescription;

    private String name;

    private Integer ratings;

    private Double price;

    private Double originalPrice;
}
