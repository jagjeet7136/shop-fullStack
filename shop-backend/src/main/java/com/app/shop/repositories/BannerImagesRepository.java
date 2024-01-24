package com.app.shop.repositories;

import com.app.shop.entities.BannerImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
BannerImagesRepository extends JpaRepository<BannerImages, Long> {

}
