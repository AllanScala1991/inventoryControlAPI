package com.example.inventorycontrol.api.dto.login;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class LoginDTO {
    @NotBlank String username;
    @NotBlank String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
