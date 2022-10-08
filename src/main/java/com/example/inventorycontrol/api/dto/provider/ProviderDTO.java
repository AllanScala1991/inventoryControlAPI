package com.example.inventorycontrol.api.dto.provider;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProviderDTO {
    @NotBlank
    @Size(max = 200)
    private String corporateName;

    @Size(max = 14)
    private String cnpj;

    @NotBlank
    @Size(max = 200)
    private String fantasyName;

    @NotBlank
    @Size(max = 30)
    private String cep;

    @NotBlank
    @Size(max = 500)
    private String address;

    @NotBlank
    @Size(max = 30)
    private String phone;

    @NotBlank
    @Size(max = 100)
    private String mail;

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
