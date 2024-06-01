package com.app.shop.repositories;

import com.app.shop.entities.TopSellingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopSellingProductRepository extends JpaRepository<TopSellingProduct, Long> {
}
