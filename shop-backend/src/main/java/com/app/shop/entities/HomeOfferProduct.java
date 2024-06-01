package com.app.shop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "home_offers")
public class HomeOfferProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String imageDescription;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_banner_id")
    @JsonIgnore
    private ProductsBanner productsBanner;
}
