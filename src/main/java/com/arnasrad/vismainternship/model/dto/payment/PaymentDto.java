package com.arnasrad.vismainternship.model.dto.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDto {

    private String id;
    private String state;
    @JsonProperty("completed_at")
    private Date completedAt;

    public PaymentDto() {
    }

    public PaymentDto(String id, String state, Date completedAt) {
        this.id = id;
        this.state = state;
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

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }
}
