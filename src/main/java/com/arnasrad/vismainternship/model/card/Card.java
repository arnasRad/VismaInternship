package com.arnasrad.vismainternship.model.card;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card {

    @Id
    private String cardId;
    private String customerId;
    private String accountNumber;
    private String creditBalance;
    private String debitBalance;
    private String cardType;
    private String productName;

    public Card() {
    }

    public Card(String customerId, String cardId, String accountNumber, String creditBalance, String debitBalance, String cardType, String productName) {
        this.customerId = customerId;
        this.cardId = cardId;
        this.accountNumber = accountNumber;
        this.creditBalance = creditBalance;
        this.debitBalance = debitBalance;
        this.cardType = cardType;
        this.productName = productName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
