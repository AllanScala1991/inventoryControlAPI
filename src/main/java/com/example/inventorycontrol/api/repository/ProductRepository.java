package com.example.inventorycontrol.api.repository;

import com.example.inventorycontrol.api.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
    boolean existsByName(String name);

    Optional<ProductModel> findByName(String name);

    List<ProductModel> findByProviderCnpj(String providerCnpj);
}
