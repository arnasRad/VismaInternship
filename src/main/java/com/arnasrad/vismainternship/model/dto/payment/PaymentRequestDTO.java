package com.arnasrad.vismainternship.model.dto.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequestDTO implements Serializable {

    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("account_id")
    private String accountId;
    private PaymentReceiverDTO receiver;
    private String bankId;
    private double amount;
    private String currency;
    private String reference;
    private String state;

    public PaymentRequestDTO() {
    }

    public PaymentRequestDTO(String requestId, String accountId, PaymentReceiverDTO receiver, String bankId,
                             Double amount, String currency, String reference, String state) {
        this.requestId = requestId;
        this.accountId = accountId;
        this.receiver = receiver;
        this.bankId = bankId;
        this.amount = amount;
        this.currency = currency;
        this.reference = reference;
        this.state = state;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public PaymentReceiverDTO getReceiver() {
        return receiver;
    }

    public void setReceiver(PaymentReceiverDTO receiver) {
        this.receiver = receiver;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
