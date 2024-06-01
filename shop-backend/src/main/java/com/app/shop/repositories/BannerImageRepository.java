package com.app.shop.repositories;

import com.app.shop.entities.BannerImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
BannerImageRepository extends JpaRepository<BannerImage, Long> {

}
