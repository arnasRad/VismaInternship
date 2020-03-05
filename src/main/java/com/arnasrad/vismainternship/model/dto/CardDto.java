package com.arnasrad.vismainternship.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDto {

    private String accountNumber;
    private String creditBalance;
    private String debitBalance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(String creditBalance) {
        this.creditBalance = creditBalance;
    }

    public String getDebitBalance() {
        return debitBalance;
    }

    public void setDebitBalance(String debitBalance) {
        this.debitBalance = debitBalance;
    }
}
