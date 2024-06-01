package com.app.shop.model.response;

import com.app.shop.model.dto.*;
import lombok.Data;
import java.util.List;

@Data
public class HomeResponse {

    private List<BannerImagesDTO> bannerImages;

    private List<HomeOfferCategoryDTO> latestOffers;

    private List<HomeOfferCategoryDTO> categories;

    private List<HomeProductsDTO> topSellingProducts;

    private List<AdBannerDTO> adBanners;

    private List<LinearProductsDTO> linearProductsDTO;

    private List<ProductsBannerDTO> productsBannerDTO;

}
