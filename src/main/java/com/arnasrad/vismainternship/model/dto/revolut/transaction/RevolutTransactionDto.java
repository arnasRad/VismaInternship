package com.arnasrad.vismainternship.model.dto.revolut.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutTransactionDto {

    private String id;
    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("reason_code")
    private String reasonCode;
    private String type;
    private String state;
    private String reference;
    @JsonProperty("scheduled_for")
    private Date scheduledFor;
    @JsonProperty("related_transaction_id")
    private String relatedTransactionId;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("completed_at")
    private Date completedAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    private MerchantDto merchant;
    @JsonProperty("legs")
    private List<TransactionLegsDto> transactionLegs;
    private TransactionCardDto card;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getScheduledFor() {
        return scheduledFor;
    }

    public void setScheduledFor(Date scheduledFor) {
        this.scheduledFor = scheduledFor;
    }

    public String getRelatedTransactionId() {
        return relatedTransactionId;
    }

    public void setRelatedTransactionId(String relatedTransactionId) {
        this.relatedTransactionId = relatedTransactionId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public MerchantDto getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantDto merchant) {
        this.merchant = merchant;
    }

    public List<TransactionLegsDto> getTransactionLegs() {
        return transactionLegs;
    }

    public void setTransactionLegs(List<TransactionLegsDto> transactionLegs) {
        this.transactionLegs = transactionLegs;
    }

    public TransactionCardDto getCard() {
        return card;
    }

    public void setCard(TransactionCardDto card) {
        this.card = card;
    }
}
