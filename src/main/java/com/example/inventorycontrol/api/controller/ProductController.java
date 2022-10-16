package com.example.inventorycontrol.api.controller;

import com.example.inventorycontrol.api.dto.product.ProductDTO;
import com.example.inventorycontrol.api.model.ProductModel;
import com.example.inventorycontrol.api.service.ProductService;
import com.example.inventorycontrol.api.service.ProviderService;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/inventory/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProviderService providerService;

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        boolean existsProvider = providerService.existsByCnpj(productDTO.getProviderCnpj());
        if(!existsProvider) {
            JSONObject response = new JSONObject();
            response.put("message", "Provider not found, try again.");
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.toString());
        }

        List<ProductModel> products = productService.findProductByProviderCnpj(productDTO.getProviderCnpj());
        for(ProductModel product : products) {
            if(product.getProductBrand().equals(productDTO.getProductBrand()) &&
                    product.getName().equals(productDTO.getName())) {
                JSONObject response = new JSONObject();
                response.put("message", "Product already registered, try again.");
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.toString());
            }
        }

        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productDTO, productModel);
        productModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        productModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productModel));
    }
}
