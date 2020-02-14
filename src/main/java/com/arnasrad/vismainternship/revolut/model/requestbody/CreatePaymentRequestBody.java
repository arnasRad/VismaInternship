package com.arnasrad.vismainternship.revolut.model.requestbody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatePaymentRequestBody {

    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("account_id")
    private String accountId;
    private ReceiverBody receiver;
    private Double amount;
    private String currency;
    private String reference;

    public CreatePaymentRequestBody() {
    }

    public CreatePaymentRequestBody(String requestId, String accountId, ReceiverBody receiver, Double amount, String currency, String reference) {
        this.requestId = requestId;
        this.accountId = accountId;
        this.receiver = receiver;
        this.amount = amount;
        this.currency = currency;
        this.reference = reference;
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

    public ReceiverBody getReceiver() {
        return receiver;
    }

    public void setReceiver(ReceiverBody receiver) {
        this.receiver = receiver;
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
}
