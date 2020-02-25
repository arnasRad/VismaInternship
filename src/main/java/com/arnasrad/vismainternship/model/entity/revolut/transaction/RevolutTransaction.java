package com.arnasrad.vismainternship.model.entity.revolut.transaction;

import com.arnasrad.vismainternship.model.entity.transaction.Transaction;
import com.arnasrad.vismainternship.model.entity.transaction.TransactionCard;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutTransaction extends Transaction {

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
    @ManyToOne
    private Merchant merchant;
    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "revolutTransaction")
    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty("legs")
    private List<RevolutTransactionLegs> revolutTransactionLegs;
    @ManyToOne
    private TransactionCard card;

    public RevolutTransaction() {
    }

    public RevolutTransaction(String id, String type, String state, Date createdAt, Date completedAt,
                              String reference, String requestId, String reasonCode, Date updatedAt,
                              Date scheduledFor, String relatedTransactionId, Merchant merchant,
                              List<RevolutTransactionLegs> revolutTransactionLegs, TransactionCard card) {

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

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public List<RevolutTransactionLegs> getRevolutTransactionLegs() {
        return revolutTransactionLegs;
    }

    public void setRevolutTransactionLegs(List<RevolutTransactionLegs> revolutTransactionLegs) {
        this.revolutTransactionLegs = revolutTransactionLegs;
    }

    public TransactionCard getCard() {
        return card;
    }

    public void setCard(TransactionCard card) {
        this.card = card;
    }
}
