package com.arnasrad.vismainternship.model.entity.payment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentRequest {

    @Id
    private String requestId;
    private String state;

    public PaymentRequest() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
