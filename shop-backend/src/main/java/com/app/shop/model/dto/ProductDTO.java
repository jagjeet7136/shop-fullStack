package com.app.shop.model.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String imageUrl;

    private String imageDescription;

    private String name;

    private Double price;

    private Double discountPrice;

    private String description;

    private Double ratings;

}
