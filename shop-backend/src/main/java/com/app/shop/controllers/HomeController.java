package com.app.shop.controllers;

import com.app.shop.model.response.HomeResponse;
import com.app.shop.services.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
@Slf4j
@Validated
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping
    public ResponseEntity<HomeResponse> getBannerImages() {
        log.info("Home page requested");
        return ResponseEntity.ok(homeService.getHomepage());
    }
}
