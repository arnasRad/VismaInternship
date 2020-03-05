package com.arnasrad.vismainternship.model.dto;

import java.io.Serializable;

public class PaymentAccountReference implements Serializable {

    private String iban;
    private String code;
    private String name;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
