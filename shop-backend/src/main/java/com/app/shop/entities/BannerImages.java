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
@Table(name = "banner_images")
public class BannerImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String description;
}
