package com.arnasrad.vismainternship.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDetails {

    @Id
    @JsonProperty("account_no")
    private String accountNo;

    private String iban;
    private String[] schemas;

    @JsonProperty("bank_country")
    private String bankCountry;

    public AccountDetails() {
    }

    public AccountDetails(String iban, String[] schemas, String accountNo, String bankCountry) {
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

    public String[] getSchemas() {
        return schemas;
    }

    public void setSchemas(String[] schemas) {
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
