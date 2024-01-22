package com.app.shop.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("home")
@Slf4j
@Validated
public class HomeController {
    @GetMapping
    public List<String> getBannerImages() {
        log.info("Home page requested");

        return null;
    }
}
