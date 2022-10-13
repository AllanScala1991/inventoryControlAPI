package com.example.inventorycontrol.api.dto.productGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductGroupDTO {
    @NotBlank
    @Size(max = 100)
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
