package com.app.shop.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@DynamicUpdate
@Table(name = "top_selling_products")
public class TopSellingProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String name;

    private Integer ratings;

    private Double price;

}
