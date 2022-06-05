package com.miu.edu.cs590.catalog.controller;

import com.miu.edu.cs590.catalog.common.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CatalogController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/catalog")
    public Product[] getProducts() {
        return restTemplate.getForObject("http://PRODUCT-SERVICE/products", Product[].class);
    }

}
