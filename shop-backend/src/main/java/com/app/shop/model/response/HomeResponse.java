package com.app.shop.model.response;

import com.app.shop.model.dto.BannerImagesDTO;
import com.app.shop.model.dto.HomeOfferCategoryDTO;
import com.app.shop.model.dto.HomeProductsDTO;
import lombok.Data;
import java.util.List;

@Data
public class HomeResponse {

    List<BannerImagesDTO> bannerImages;

    List<HomeOfferCategoryDTO> latestOffers;

    List<HomeOfferCategoryDTO> categories;

    List<HomeProductsDTO> topSellingProducts;


}
