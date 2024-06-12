package com.app.shop.model.response;

import com.app.shop.model.dto.*;
import lombok.Data;
import java.util.List;

@Data
public class HomeResponse {

    private List<AdBannerDTO> adBanners;

    private List<BannerImagesDTO> bannerImages;

    private List<CategoryDTO> categories;

    private List<ProductDTO> topSellingProducts;

    private List<LinearProductsDTO> linearProductsDTO;

    private List<ProductsBannerDTO> productsBannerDTO;

    private List<ProductDTO> latestOffers;

}
