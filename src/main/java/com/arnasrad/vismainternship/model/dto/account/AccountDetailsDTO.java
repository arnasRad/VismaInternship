package com.arnasrad.vismainternship.model.dto.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDetailsDTO {

    @JsonProperty("account_no")
    private String accountNo;
    private String iban;
    private List<String> schemas;
    @JsonProperty("bank_country")
    private String bankCountry;

    public AccountDetailsDTO() {
    }

    public AccountDetailsDTO(String iban, List<String> schemas, String accountNo, String bankCountry) {
        this.iban = iban;
        this.schemas = schemas;
        this.accountNo = accountNo;
        this.bankCountry = bankCountry;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public List<String> getSchemas() {
        return schemas;
    }

    public void setSchemas(List<String> schemas) {
        this.schemas = schemas;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }
}
