package com.app.shop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String imageDescription;

    private String name;

    private Double price;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "linear_product_id")
    @JsonIgnore
    private LinearProduct linearProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_offer_product_id")
    @JsonIgnore
    private HomeOfferProduct homeOfferProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_banner_id")
    @JsonIgnore
    private ProductsBanner productsBanner;

    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private TopSellingProduct topSellingProduct;
}
