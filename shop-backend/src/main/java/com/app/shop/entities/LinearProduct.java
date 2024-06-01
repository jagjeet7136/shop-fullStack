package com.app.shop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@DynamicUpdate
@Table(name = "linear_products")
public class LinearProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String heading;

    private String offer;

    private String price;

    private String productName;
}
