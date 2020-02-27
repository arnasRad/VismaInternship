package com.arnasrad.vismainternship.model.dto.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentReceiverDTO implements Serializable {

    @JsonProperty("counterparty_id")
    private String counterpartyId;
    @JsonProperty("account_id")
    private String accountId;

    public PaymentReceiverDTO() {
    }

    public PaymentReceiverDTO(String counterpartyId, String accountId) {
        this.counterpartyId = counterpartyId;
        this.accountId = accountId;
    }

    public String getCounterpartyId() {
        return counterpartyId;
    }

    public void setCounterpartyId(String counterpartyId) {
        this.counterpartyId = counterpartyId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
