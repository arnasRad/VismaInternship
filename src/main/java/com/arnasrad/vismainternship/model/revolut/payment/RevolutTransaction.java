package com.arnasrad.vismainternship.model.revolut.payment;

import com.arnasrad.vismainternship.model.payment.Transaction;
import com.arnasrad.vismainternship.model.payment.TransactionCard;
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
    // TODO: legs not shown when fetching from DB
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "revolutTransaction")
    private List<RevolutTransactionLegs> legs;
    @ManyToOne
    private TransactionCard card;

    public RevolutTransaction() {
    }

    public RevolutTransaction(String id, String type, String state, Date createdAt, Date completedAt,
                              String reference, String requestId, String reasonCode, Date updatedAt,
                              Date scheduledFor, String relatedTransactionId, Merchant merchant,
                              List<RevolutTransactionLegs> legs, TransactionCard card) {

        super(id, type, state, createdAt, completedAt, reference);
        this.requestId = requestId;
        this.reasonCode = reasonCode;
        this.updatedAt = updatedAt;
        this.scheduledFor = scheduledFor;
        this.relatedTransactionId = relatedTransactionId;
        this.merchant = merchant;
        this.legs = legs;
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

    public List<RevolutTransactionLegs> getLegs() {
        return legs;
    }

    public void setLegs(List<RevolutTransactionLegs> legs) {
        this.legs = legs;
    }

    public TransactionCard getCard() {
        return card;
    }

    public void setCard(TransactionCard card) {
        this.card = card;
    }
}
