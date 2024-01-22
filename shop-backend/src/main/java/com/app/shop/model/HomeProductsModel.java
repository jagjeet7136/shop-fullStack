package com.app.shop.model;

import lombok.Data;

@Data
public class HomeProductsModel {

    private String imageUrl;
    private String name;
    private Integer ratings;
    private Double price;
}
