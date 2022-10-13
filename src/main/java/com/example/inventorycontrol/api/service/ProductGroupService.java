package com.example.inventorycontrol.api.service;

import com.example.inventorycontrol.api.model.ProductGroupModel;
import com.example.inventorycontrol.api.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductGroupService {
    @Autowired
    ProductGroupRepository productGroupRepository;

    public Optional<ProductGroupModel> findProductGroupById(UUID id) {
        return productGroupRepository.findById(id);
    }

    public List<ProductGroupModel> findAllProductGroups() {
        return productGroupRepository.findAll();
    }

    public boolean existsProductByName(String name) {
        return productGroupRepository.existsByName(name);
    }

    public ProductGroupModel createProductGroup(ProductGroupModel productGroupModel) {
        return productGroupRepository.save(productGroupModel);
    }

    public void deleteProductGroup(UUID id) {
        productGroupRepository.deleteById(id);
    }
}
