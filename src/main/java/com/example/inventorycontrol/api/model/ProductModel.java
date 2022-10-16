package com.example.inventorycontrol.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "Product")
public class ProductModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(nullable = false, length = 14)
    String providerCnpj;

    @Column(nullable = false, length = 100)
    String name;

    @Column(nullable = false, length = 100)
    String productBrand;

    @Column(nullable = false, length = 3)
    String unitOfMeasurement;

    @Column(nullable = false)
    BigDecimal cost;

    @Column(nullable = false)
    BigDecimal salePrice;

    @Column(nullable = false)
    LocalDateTime createdAt;

    @Column(nullable = false)
    LocalDateTime updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProviderCnpj() {
        return providerCnpj;
    }

    public void setProviderCnpj(String providerCnpj) {
        this.providerCnpj = providerCnpj;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
