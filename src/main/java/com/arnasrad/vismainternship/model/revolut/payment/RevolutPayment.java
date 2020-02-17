package com.arnasrad.vismainternship.model.revolut.payment;

import com.arnasrad.vismainternship.model.Payment;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutPayment extends Payment {

    @JsonProperty("reason_code")
    private String reasonCode;
    @JsonProperty("created_at")
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