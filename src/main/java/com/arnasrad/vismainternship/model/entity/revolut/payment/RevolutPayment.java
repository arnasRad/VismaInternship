package com.arnasrad.vismainternship.model.entity.revolut.payment;

import com.arnasrad.vismainternship.model.entity.payment.Payment;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class RevolutPayment extends Payment {

    private String reasonCode;
    private Date createdAt;

    public RevolutPayment() {
    }

    public RevolutPayment(String id, String state, Date completedAt, String reasonCode, Date createdAt) {
        super(id, state, completedAt);
        this.reasonCode = reasonCode;
        this.createdAt = createdAt;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
