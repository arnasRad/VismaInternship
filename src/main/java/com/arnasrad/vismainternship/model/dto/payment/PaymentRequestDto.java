package com.arnasrad.vismainternship.model.dto.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequestDto implements Serializable {

    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("account_id")
    private String accountId;
    private PaymentReceiverDto receiver;
    private String bankId;
    private double amount;
    private String currency;
    private String reference;
    private String state;

    public PaymentRequestDto() {
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

    public PaymentReceiverDto getReceiver() {
        return receiver;
    }

    public void setReceiver(PaymentReceiverDto receiver) {
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
