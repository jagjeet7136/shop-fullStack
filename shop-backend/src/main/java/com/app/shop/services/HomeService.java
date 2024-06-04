package com.app.shop.services;

import com.app.shop.model.dto.*;
import com.app.shop.repositories.*;
import com.app.shop.model.response.HomeResponse;
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
    private BannerImageRepository bannerImageRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private HomeOfferRepository homeOfferRepository;

    @Autowired
    private TopSellingProductRepository topSellingProductRepository;

    @Autowired
    private AdBannerRepository adBannerRepository;

    @Autowired
    private LinearProductRepository linearProductRepository;

    @Autowired
    private ProductsBannerRepository productsBannerRepository;

    @Autowired
    private ModelMapper modelMapper;

    private <S, T> List<T> mapEntityListToModelList(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream()
                .map(sourceEntity -> modelMapper.map(sourceEntity, targetClass))
                .collect(Collectors.toList());
    }

    public HomeResponse getHomepage() {
        HomeResponse homeResponse = new HomeResponse();
//        homeResponse.setBannerImages(mapEntityListToModelList(bannerImageRepository.findAll(), BannerImagesDTO.class));
//        homeResponse.setCategories(mapEntityListToModelList(categoryRepository.findAll(),
//                HomeOfferCategoryDTO.class));
//        homeResponse.setLatestOffers(mapEntityListToModelList(homeOfferRepository.findAll(),
//                HomeOfferCategoryDTO.class));
//        homeResponse.setTopSellingProducts(mapEntityListToModelList(topSellingProductRepository.findAll(),
//                HomeProductsDTO.class));
//        homeResponse.setAdBanners(mapEntityListToModelList(adBannerRepository.findAll(), AdBannerDTO.class));
//        homeResponse.setLinearProductsDTO(mapEntityListToModelList(linearProductRepository.findAll(),
//                LinearProductsDTO.class));
//        homeResponse.setProductsBannerDTO(null);
        return homeResponse;
    }


}
