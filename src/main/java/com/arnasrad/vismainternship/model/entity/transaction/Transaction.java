package com.arnasrad.vismainternship.model.entity.transaction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionId;
    private String type;
    private String state;
    private Date createdAt;
    private Date completedAt;
    private String reference;
    private String requestId;
    private String reasonCode;
    private Date updatedAt;
    private Date scheduledFor;
    private String relatedTransactionId;
    @ManyToOne
    private Merchant merchant;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TransactionLegs> transactionLegs;
    @ManyToOne
    private TransactionCard card;

    public Transaction() {
    }

    public Transaction(String transactionId, String type, String state, Date createdAt, Date completedAt,
                       String reference, String requestId, String reasonCode, Date updatedAt, Date scheduledFor,
                       String relatedTransactionId, Merchant merchant, List<TransactionLegs> transactionLegs,
                       TransactionCard card) {
        this.transactionId = transactionId;
        this.type = type;
        this.state = state;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.reference = reference;
        this.requestId = requestId;
        this.reasonCode = reasonCode;
        this.updatedAt = updatedAt;
        this.scheduledFor = scheduledFor;
        this.relatedTransactionId = relatedTransactionId;
        this.merchant = merchant;
        this.transactionLegs = transactionLegs;
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public List<TransactionLegs> getTransactionLegs() {
        return transactionLegs;
    }

    public void setTransactionLegs(List<TransactionLegs> transactionLegs) {
        this.transactionLegs = transactionLegs;
    }

    public TransactionCard getCard() {
        return card;
    }

    public void setCard(TransactionCard card) {
        this.card = card;
    }
}
