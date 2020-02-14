package com.arnasrad.vismainternship.revolut.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment {

    private String id;
    private String state;
    @JsonProperty("reason_code")
    private String reasonCode;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("completed_at")
    private Date completedAt;

    public Payment() {
    }

    public Payment(String id, String state, String reasonCode, Date createdAt, Date completedAt) {
        this.id = id;
        this.state = state;
        this.reasonCode = reasonCode;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }
}
