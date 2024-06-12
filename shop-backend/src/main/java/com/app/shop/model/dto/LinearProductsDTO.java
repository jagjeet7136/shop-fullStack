package com.app.shop.model.dto;

import lombok.Data;
import java.util.List;

@Data
public class LinearProductsDTO {

    private String heading;

    private String description;

    private List<ProductDTO> productDTOS;
}
