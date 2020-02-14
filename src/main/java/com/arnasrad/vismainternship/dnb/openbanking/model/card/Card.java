package com.arnasrad.vismainternship.dnb.openbanking.model.card;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card {

    private BlockingInfo blockingInfo;
    private String created;
    private String creditBalance;
    private String debitBalance;
    private String lastChanged;
    private String cardId;
    private String maskedCardNumber;
    private String customerId;
    private String cardHolderName;
    private String cardType;
    private String productName;
    private String accountNumber;
    private String cardStatus;

    public Card() {
    }

    public Card(BlockingInfo blockingInfo, String created, String creditBalance, String debitBalance, String lastChanged, String cardId, String maskedCardNumber, String customerId, String cardHolderName, String cardType, String productName, String accountNumber, String cardStatus) {
        this.blockingInfo = blockingInfo;
        this.created = created;
        this.creditBalance = creditBalance;
        this.debitBalance = debitBalance;
        this.lastChanged = lastChanged;
        this.cardId = cardId;
        this.maskedCardNumber = maskedCardNumber;
        this.customerId = customerId;
        this.cardHolderName = cardHolderName;
        this.cardType = cardType;
        this.productName = productName;
        this.accountNumber = accountNumber;
        this.cardStatus = cardStatus;
    }

    public BlockingInfo getBlockingInfo() {
        return blockingInfo;
    }

    public void setBlockingInfo(BlockingInfo blockingInfo) {
        this.blockingInfo = blockingInfo;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
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

    public String getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(String lastChanged) {
        this.lastChanged = lastChanged;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    public void setMaskedCardNumber(String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }
}
