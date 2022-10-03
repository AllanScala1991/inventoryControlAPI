package com.example.inventorycontrol.api.repository;

import com.example.inventorycontrol.api.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    boolean existsByUsername(String username);

    boolean existsByMail(String mail);

    Optional<UserModel> findByUsername(String username);
}
