package com.example.inventorycontrol.api.controller;

import com.example.inventorycontrol.api.dto.provider.ProviderDTO;
import com.example.inventorycontrol.api.model.ProviderModel;
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
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/inventory/api/provider")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @PostMapping
    public ResponseEntity<Object> createProvider(@RequestBody @Valid ProviderDTO providerDTO) {
        boolean existsCorporateName = providerService.existsByCnpj(providerDTO.getCnpj());
        boolean existsByMail = providerService.existsByMail(providerDTO.getMail());
        if(existsCorporateName && existsByMail) {
            JSONObject response = new JSONObject();
            response.put("message", "Provider already registry, try again.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response.toString());
        }

        ProviderModel providerModel = new ProviderModel();
        BeanUtils.copyProperties(providerDTO, providerModel);
        providerModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        providerModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(providerService.createProvider(providerModel));
    }

    @GetMapping
    public ResponseEntity<Object> findAllProviders() {
        return ResponseEntity.status(HttpStatus.OK).body(providerService.findAllProviders());
    }

    @GetMapping("/{fantasyName}")
    public ResponseEntity<Object> findProviderByFantasyName(@PathVariable(value = "fantasyName") String fantasyName) {
        Optional<ProviderModel> provider = providerService.findProviderByFantasyName(fantasyName);

        if(!provider.isPresent()) {
            JSONObject response = new JSONObject();
            response.put("message", "Provider not found, try again.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.toString());
        }

        return ResponseEntity.status(HttpStatus.OK).body(provider);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findProviderById(@PathVariable(value = "id") UUID id) {
        Optional<ProviderModel> provider = providerService.findProviderById(id);

        if(!provider.isPresent()) {
            JSONObject response = new JSONObject();
            response.put("message", "Provider not found, try again.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.toString());
        }

        return ResponseEntity.status(HttpStatus.OK).body(provider);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProvider(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProviderDTO providerDTO) {
        Optional<ProviderModel> provider = providerService.findProviderById(id);
        if(!provider.isPresent()) {
            JSONObject response = new JSONObject();
            response.put("message", "Provider not found, try again.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.toString());
        }

        ProviderModel providerModel = new ProviderModel();
        BeanUtils.copyProperties(providerDTO, providerModel);
        providerModel.setId(provider.get().getId());
        providerModel.setCreatedAt(provider.get().getCreatedAt());
        providerModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.OK).body(providerService.createProvider(providerModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProvider(@PathVariable(value = "id") UUID id) {
        Optional<ProviderModel> provider = providerService.findProviderById(id);
        if(!provider.isPresent()) {
            JSONObject response = new JSONObject();
            response.put("message", "Provider not found, try again.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.toString());
        }

        providerService.deleteProviderById(id);

        JSONObject response = new JSONObject();
        response.put("message", "Provider deleted successfully");

        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }
}
