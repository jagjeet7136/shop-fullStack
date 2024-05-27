package com.app.shop.model.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProductsBannerDTO {
    private String headingOne;
    private String headingTwo;
    private String buttonText;
    private List<HomeProductsDTO> products;
}
