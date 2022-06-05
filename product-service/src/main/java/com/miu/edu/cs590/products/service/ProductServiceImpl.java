package com.miu.edu.cs590.products.service;

import com.miu.edu.cs590.products.domain.Product;
import com.miu.edu.cs590.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void changeQuantity(String name, Integer quantity) {
        Product product = productRepository.findByName(name);
        product.setQuantity(product.getQuantity() - quantity);
        checkStock(product);
        productRepository.save(product);
    }
    private void checkStock(Product product) {
        if(product.getQuantity() <= 10) {
            product.setQuantity(product.getQuantity() + 20);
        }
    }

}
