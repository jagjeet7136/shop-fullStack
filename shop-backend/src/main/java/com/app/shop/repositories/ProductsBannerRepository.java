package com.app.shop.repositories;

import com.app.shop.entities.ProductsBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsBannerRepository extends JpaRepository<ProductsBanner, Long> {
}
