package com.arnasrad.vismainternship.model.entity.payment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String senderAccountId;
    private String receiverAccountId;
    private String state;

    public PaymentMessage() {
    }

    public PaymentMessage(String senderAccountId, String receiverAccountId, String state) {
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(String senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public String getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(String receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
