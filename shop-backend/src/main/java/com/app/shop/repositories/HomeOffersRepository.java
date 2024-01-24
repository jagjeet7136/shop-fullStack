package com.app.shop.repositories;

import com.app.shop.entities.HomeOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeOffersRepository extends JpaRepository<HomeOffers, Long> {
}
