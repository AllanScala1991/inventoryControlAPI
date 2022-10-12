package com.example.inventorycontrol.api.service;

import com.example.inventorycontrol.api.model.ProductGroupModel;
import com.example.inventorycontrol.api.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductGroupService {
    @Autowired
    ProductGroupRepository productGroupRepository;

    public Optional<ProductGroupModel> findProductGroupById(UUID id) {
        return productGroupRepository.findById(id);
    }
}
