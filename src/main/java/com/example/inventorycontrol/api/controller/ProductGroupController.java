package com.example.inventorycontrol.api.controller;

import com.example.inventorycontrol.api.dto.productGroup.ProductGroupDTO;
import com.example.inventorycontrol.api.model.ProductGroupModel;
import com.example.inventorycontrol.api.service.ProductGroupService;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/inventory/api/product/group")
public class ProductGroupController {
    @Autowired
    ProductGroupService productGroupService;

    @PostMapping
    public ResponseEntity<Object> createProductGroup(@RequestBody @Valid ProductGroupDTO productGroupDTO) {
        if(productGroupService.existsProductByName(productGroupDTO.getName())) {
            JSONObject response = new JSONObject();
            response.put("message", "Product group already exists, try other name");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response.toString());
        }

        ProductGroupModel productGroupModel = new ProductGroupModel();
        BeanUtils.copyProperties(productGroupDTO, productGroupModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(productGroupService.createProductGroup(productGroupModel));
    }

    @GetMapping
    public ResponseEntity<Object> findAllProductsGroups() {
        return ResponseEntity.status(HttpStatus.OK).body(productGroupService.findAllProductGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findProductByName(@PathVariable(value = "id") UUID id) {
        Optional<ProductGroupModel> product = productGroupService.findProductGroupById(id);

        if(!product.isPresent()) {
            JSONObject response = new JSONObject();
            response.put("message", "Product group not found, try again");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.toString());
        }

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductGroup(@PathVariable(value = "id") UUID id) {
        Optional<ProductGroupModel> product = productGroupService.findProductGroupById(id);

        if(!product.isPresent()) {
            JSONObject response = new JSONObject();
            response.put("message", "Product group not found, try again");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.toString());
        }

        productGroupService.deleteProductGroup(id);

        JSONObject response = new JSONObject();
        response.put("message", "Product group successfully deleted.");

        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }
}
