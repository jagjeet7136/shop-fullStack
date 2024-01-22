package com.app.shop.response;

import com.app.shop.model.HomeOfferCategoryPromiseModel;
import com.app.shop.model.HomeProductsModel;
import lombok.Data;
import java.util.List;

@Data
public class HomeResponse {

    List<String> bannerImages;

    List<HomeOfferCategoryPromiseModel> latestOffers;

    List<HomeOfferCategoryPromiseModel> categories;

    List<HomeProductsModel> topSellingProducts;
}
