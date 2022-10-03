package com.example.inventorycontrol.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class UserCreateDTO {
    @NotBlank
    @Size(max = 150)
    private String name;

    @NotBlank
    @Size(max = 10)
    private String username;

    @NotBlank
    @Size(max = 30)
    private String password;

    @NotBlank
    @Size(max = 100)
    private String mail;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
