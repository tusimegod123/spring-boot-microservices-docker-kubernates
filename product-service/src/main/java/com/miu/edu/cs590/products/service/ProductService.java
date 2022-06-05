package com.miu.edu.cs590.products.service;


import com.miu.edu.cs590.products.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product getProductByName(String name);
    void saveProduct(Product product);

    void changeQuantity(String name, Integer quantity);


}
