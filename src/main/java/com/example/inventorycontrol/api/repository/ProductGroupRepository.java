package com.example.inventorycontrol.api.repository;

import com.example.inventorycontrol.api.model.ProductGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroupModel, UUID> {

}
