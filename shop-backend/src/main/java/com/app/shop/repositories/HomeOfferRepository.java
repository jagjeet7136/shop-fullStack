package com.app.shop.repositories;

import com.app.shop.entities.HomeOfferProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeOfferRepository extends JpaRepository<HomeOfferProduct, Long> {
}
