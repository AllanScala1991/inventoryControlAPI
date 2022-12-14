package com.example.inventorycontrol.api.service;

import com.example.inventorycontrol.api.model.ProviderModel;
import com.example.inventorycontrol.api.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository providerRepository;

    @Transactional
    public ProviderModel createProvider(ProviderModel providerModel) {
        return providerRepository.save(providerModel);
    }

    public Optional<ProviderModel> findProviderById(UUID id) {
        return  providerRepository.findById(id);
    }

    public Optional<ProviderModel> findProviderByFantasyName(String fantasyName) {
        return providerRepository.findByFantasyName(fantasyName);
    }

    public List<ProviderModel> findAllProviders() {
        return providerRepository.findAll();
    }

    public boolean existsByCnpj(String cnpj) {
        return providerRepository.existsByCnpj(cnpj);
    }

    public boolean existsByMail(String mail){
        return providerRepository.existsByMail(mail);
    }

    public void deleteProviderById(UUID id) {
        providerRepository.deleteById(id);
    }
}
