package com.app.shop.repositories;

import com.app.shop.entities.AdBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdBannerRepository extends JpaRepository<AdBanner, Long> {
}
