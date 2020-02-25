package com.arnasrad.vismainternship.model.dto.revolut.transaction;

import com.arnasrad.vismainternship.model.dto.transaction.TransactionCardDTO;
import com.arnasrad.vismainternship.model.dto.transaction.TransactionDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutTransactionDTO extends TransactionDTO {

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
    private MerchantDTO merchant;
    @JsonProperty("legs")
    private List<RevolutTransactionLegsDTO> revolutTransactionLegs;
    private TransactionCardDTO card;

    public RevolutTransactionDTO() {
    }

    public RevolutTransactionDTO(String id, String type, String state, Date createdAt, Date completedAt,
                                 String reference, String requestId, String reasonCode, Date updatedAt,
                                 Date scheduledFor, String relatedTransactionId, MerchantDTO merchant,
                                 List<RevolutTransactionLegsDTO> revolutTransactionLegs, TransactionCardDTO card) {
        super(id, type, state, createdAt, completedAt, reference);
        this.requestId = requestId;
        this.reasonCode = reasonCode;
        this.updatedAt = updatedAt;
        this.scheduledFor = scheduledFor;
        this.relatedTransactionId = relatedTransactionId;
        this.merchant = merchant;
        this.revolutTransactionLegs = revolutTransactionLegs;
        this.card = card;
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

    public MerchantDTO getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantDTO merchant) {
        this.merchant = merchant;
    }

    public List<RevolutTransactionLegsDTO> getRevolutTransactionLegs() {
        return revolutTransactionLegs;
    }

    public void setRevolutTransactionLegs(List<RevolutTransactionLegsDTO> revolutTransactionLegs) {
        this.revolutTransactionLegs = revolutTransactionLegs;
    }

    public TransactionCardDTO getCard() {
        return card;
    }

    public void setCard(TransactionCardDTO card) {
        this.card = card;
    }
}
