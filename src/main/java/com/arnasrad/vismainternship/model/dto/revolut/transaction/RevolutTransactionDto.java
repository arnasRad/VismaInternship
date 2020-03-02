package com.arnasrad.vismainternship.model.dto.revolut.transaction;

import com.arnasrad.vismainternship.model.dto.transaction.TransactionDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutTransactionDto extends TransactionDto {

    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("reason_code")
    private String reasonCode;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("scheduled_for")
    private Date scheduledFor;
    @JsonProperty("related_transaction_id")
    private String relatedTransactionId;
    private MerchantDto merchant;
    @JsonProperty("legs")
    private List<RevolutTransactionLegsDto> revolutTransactionLegs;
    private TransactionCardDto card;

    public RevolutTransactionDto() {
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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

    public MerchantDto getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantDto merchant) {
        this.merchant = merchant;
    }

    public List<RevolutTransactionLegsDto> getRevolutTransactionLegs() {
        return revolutTransactionLegs;
    }

    public void setRevolutTransactionLegs(List<RevolutTransactionLegsDto> revolutTransactionLegs) {
        this.revolutTransactionLegs = revolutTransactionLegs;
    }

    public TransactionCardDto getCard() {
        return card;
    }

    public void setCard(TransactionCardDto card) {
        this.card = card;
    }
}
