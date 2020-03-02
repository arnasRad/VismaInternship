package com.arnasrad.vismainternship.model.dto.token;

public class DnbConsentAccountDto {

    private String bban;
    private String iban;

    public DnbConsentAccountDto() {
    }

    public String getBban() {
        return bban;
    }

    public void setBban(String bban) {
        this.bban = bban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
