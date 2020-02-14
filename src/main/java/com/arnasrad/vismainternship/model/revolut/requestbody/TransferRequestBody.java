package com.arnasrad.vismainternship.model.revolut.requestbody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferRequestBody {

    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("source_account_id")
    private String sourceAccountId;
    @JsonProperty("target_account_id")
    private String targetAccountId;
    private Double amount;
    private String currency;
    private String description;

    public TransferRequestBody() {
    }

    public TransferRequestBody(String requestId, String sourceAccountId, String targetAccountId, Double amount, String currency, String description) {
        this.requestId = requestId;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(String targetAccountId) {
        this.targetAccountId = targetAccountId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
