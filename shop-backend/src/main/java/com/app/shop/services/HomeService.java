package com.app.shop.services;

import com.app.shop.entities.LinearProduct;
import com.app.shop.entities.ProductOffer;
import com.app.shop.entities.ProductsBanner;
import com.app.shop.entities.TopSellingProduct;
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
    private ProductOfferRepository productOfferRepository;

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

        homeResponse.setAdBanners(mapEntityListToModelList(adBannerRepository.findAll(), AdBannerDTO.class));
        homeResponse.setBannerImages(mapEntityListToModelList(bannerImageRepository.findAll(), BannerImagesDTO.class));
        homeResponse.setCategories(mapEntityListToModelList(categoryRepository.findAll(),
                CategoryDTO.class));

        List<TopSellingProduct> topSellingProducts = topSellingProductRepository.findAll();
        List<ProductDTO> homeProductsDTOS = topSellingProducts.stream().map(topSellingProduct -> {
            ProductDTO homeProductsDTO = new ProductDTO();
            homeProductsDTO.setName(topSellingProduct.getProduct().getName());
            homeProductsDTO.setImageUrl(topSellingProduct.getProduct().getImageUrl());
            homeProductsDTO.setImageDescription(topSellingProduct.getProduct().getImageDescription());
            homeProductsDTO.setPrice(topSellingProduct.getProduct().getPrice());
            homeProductsDTO.setRatings(topSellingProduct.getProduct().getRatings());
            homeProductsDTO.setDiscountPrice(0.0);
            return homeProductsDTO;
        }).collect(Collectors.toList());
        homeResponse.setTopSellingProducts(homeProductsDTOS);

        List<LinearProduct> linearProducts = linearProductRepository.findAll();
        List<LinearProductsDTO> linearProductsDTOS = linearProducts.stream().map(linearProduct -> {
            LinearProductsDTO linearProductsDTO = new LinearProductsDTO();
            linearProductsDTO.setHeading(linearProduct.getHeading());
            linearProductsDTO.setDescription(linearProduct.getDescription());
            List<ProductDTO> productDTOS = mapEntityListToModelList(linearProduct.getProducts(), ProductDTO.class);
            linearProductsDTO.setProductDTOS(productDTOS);
            return linearProductsDTO;
        }).collect(Collectors.toList());
        homeResponse.setLinearProductsDTO(linearProductsDTOS);

        List<ProductsBanner> productsBanners = productsBannerRepository.findAll();
        List<ProductsBannerDTO> productsBannerDTOS = productsBanners.stream().map(productsBanner -> {
            ProductsBannerDTO productsBannerDTO = new ProductsBannerDTO();
            productsBannerDTO.setHeadingOne(productsBanner.getHeadingOne());
            productsBannerDTO.setHeadingTwo(productsBanner.getHeadingTwo());
            productsBannerDTO.setButtonText(productsBanner.getButtonText());
            List<ProductDTO> productDTOS = productsBanner.getProducts().stream().map(product -> {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setImageUrl(product.getImageUrl());
                productDTO.setImageDescription(product.getImageDescription());
                productDTO.setName(product.getName());
                productDTO.setPrice(product.getPrice());
                productDTO.setDescription(product.getDescription());
                productDTO.setRatings(product.getRatings());
                return productDTO;
            }).collect(Collectors.toList());
            productsBannerDTO.setProducts(productDTOS);
            return productsBannerDTO;
        }).collect(Collectors.toList());
        homeResponse.setProductsBannerDTO(productsBannerDTOS);

        List<ProductOffer> productOffers = productOfferRepository.findAll();
        List<ProductDTO> latestOfferDTOs = productOffers.stream()
                .flatMap(productOffer -> productOffer.getProducts().stream())
                .map(product -> {
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setImageUrl(product.getImageUrl());
                    productDTO.setImageDescription(product.getImageDescription());
                    productDTO.setName(product.getName());
                    productDTO.setPrice(product.getPrice());
                    productDTO.setDiscountPrice(0.0);
                    productDTO.setDescription(product.getDescription());
                    productDTO.setRatings(product.getRatings());
                    return productDTO;
                }).collect(Collectors.toList());
        homeResponse.setLatestOffers(latestOfferDTOs);

        return homeResponse;
    }


}
