package com.example.inventorycontrol.api.service;

import com.example.inventorycontrol.api.model.ProductModel;
import com.example.inventorycontrol.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional
    public ProductModel createProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public List<ProductModel> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductModel> findProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Optional<ProductModel> findProductById(UUID id) {
        return productRepository.findById(id);
    }

    public boolean productExistsByName(String name) {
        return productRepository.existsByName(name);
    }

    public Optional<ProductModel> findByProductProviderId(UUID productProviderId) {
        return productRepository.findByProductProviderId(productProviderId);
    }

    @Transactional
    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }
}
