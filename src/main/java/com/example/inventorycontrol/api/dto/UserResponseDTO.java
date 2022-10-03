package com.example.inventorycontrol.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class UserResponseDTO {
    @NotBlank
    private UUID id;

    @NotBlank
    @Size(max = 150)
    private String name;

    @NotBlank
    @Size(max = 10)
    private String username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
