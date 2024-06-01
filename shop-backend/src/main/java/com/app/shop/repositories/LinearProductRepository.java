package com.app.shop.repositories;

import com.app.shop.entities.LinearProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinearProductRepository extends JpaRepository<LinearProduct, Long> {
}
