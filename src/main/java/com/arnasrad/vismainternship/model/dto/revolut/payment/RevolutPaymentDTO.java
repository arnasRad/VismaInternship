package com.arnasrad.vismainternship.model.dto.revolut.payment;

import com.arnasrad.vismainternship.model.dto.payment.PaymentDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutPaymentDTO extends PaymentDTO {

    @JsonProperty("reason_code")
    private String reasonCode;
    @JsonProperty("created_at")
    private Date createdAt;

    public RevolutPaymentDTO() {
    }

    public RevolutPaymentDTO(String id, String state, Date completedAt, String reasonCode, Date createdAt) {
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
