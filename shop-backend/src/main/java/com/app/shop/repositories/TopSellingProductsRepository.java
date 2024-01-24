package com.app.shop.repositories;

import com.app.shop.entities.TopSellingProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopSellingProductsRepository extends JpaRepository<TopSellingProducts, Long> {
}
