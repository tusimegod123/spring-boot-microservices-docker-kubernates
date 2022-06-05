package com.miu.edu.cs590.products.controller;

import com.miu.edu.cs590.products.domain.Product;
import com.miu.edu.cs590.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{name}")
    public Product getProduct(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return product;
    }

    @PutMapping("products/{name}/{quantity}")
    public void changeQuantity(@PathVariable String name, @PathVariable Integer quantity) {
        productService.changeQuantity(name, quantity);
    }

}
