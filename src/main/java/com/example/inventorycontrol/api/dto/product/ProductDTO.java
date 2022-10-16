package com.example.inventorycontrol.api.dto.product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

public class ProductDTO {

    @NotBlank
    @Size(max = 14)
    String providerCnpj;

    @NotBlank
    @Size(max = 100)
    String name;

    @NotBlank
    @Size(max = 100)
    String productBrand;

    @NotBlank
    @Size(max = 3)
    String unitOfMeasurement;

    @NotNull
    BigDecimal cost;

    @NotNull
    BigDecimal salePrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductBrand() {
        return productBrand;
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

    public String getProviderCnpj() {
        return providerCnpj;
    }

    public void setProviderCnpj(String providerCnpj) {
        this.providerCnpj = providerCnpj;
    }
}
