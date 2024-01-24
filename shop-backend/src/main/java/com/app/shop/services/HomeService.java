package com.app.shop.services;

import com.app.shop.model.BannerImagesModel;
import com.app.shop.model.HomeOfferCategoryPromiseModel;
import com.app.shop.model.HomeProductsModel;
import com.app.shop.repositories.BannerImagesRepository;
import com.app.shop.repositories.CategoriesRepository;
import com.app.shop.repositories.HomeOffersRepository;
import com.app.shop.repositories.TopSellingProductsRepository;
import com.app.shop.response.HomeResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HomeService {

    @Autowired
    private BannerImagesRepository bannerImagesRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private HomeOffersRepository homeOffersRepository;

    @Autowired
    private TopSellingProductsRepository topSellingProductsRepository;

    @Autowired
    private ModelMapper modelMapper;

    private <S, T> List<T> mapEntityListToModelList(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream()
                .map(sourceEntity -> modelMapper.map(sourceEntity, targetClass))
                .collect(Collectors.toList());
    }

    public HomeResponse getHomepage() {
        HomeResponse homeResponse = new HomeResponse();
        homeResponse.setBannerImages(mapEntityListToModelList(bannerImagesRepository.findAll(), BannerImagesModel.class));
        homeResponse.setCategories(mapEntityListToModelList(categoriesRepository.findAll(),
                HomeOfferCategoryPromiseModel.class));
        homeResponse.setLatestOffers(mapEntityListToModelList(homeOffersRepository.findAll(),
                HomeOfferCategoryPromiseModel.class));
        homeResponse.setTopSellingProducts(mapEntityListToModelList(topSellingProductsRepository.findAll(),
                HomeProductsModel.class));
        return homeResponse;
    }


}
