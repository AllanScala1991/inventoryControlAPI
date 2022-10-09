package com.example.inventorycontrol.api.repository;

import com.example.inventorycontrol.api.model.ProviderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderModel, UUID> {
    Optional<ProviderModel> findByFantasyName(String fantasyName);

    boolean existsByCnpj(String cnpj);

    boolean existsByMail(String mail);
}
