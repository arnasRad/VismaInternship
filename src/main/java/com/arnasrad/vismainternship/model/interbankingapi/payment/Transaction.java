package com.arnasrad.vismainternship.model.interbankingapi.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {

    private String id;
    private String type;
    private String state;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("completed_at")
    private Date completedAt;
    private String reference;

    public Transaction() {
    }

    public Transaction(String id, String type, String state, Date createdAt, Date completedAt, String reference) {
        this.id = id;
        this.type = type;
        this.state = state;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.reference = reference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
