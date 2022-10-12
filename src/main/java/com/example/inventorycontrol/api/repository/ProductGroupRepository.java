package com.example.inventorycontrol.api.repository;

import com.example.inventorycontrol.api.model.ProductGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductGroupRepository extends JpaRepository<ProductGroupModel, UUID> {

}
