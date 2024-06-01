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
@Table(name = "ad_banners")
public class AdBanner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String backgroundImageUrl;

    private String headingOne;

    private String headingTwo;

    private String buttonText;
}
