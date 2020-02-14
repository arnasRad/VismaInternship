package com.arnasrad.vismainternship.revolut.model.requestbody;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiverBody {

    @JsonProperty("counterparty_id")
    private String counterpartyId;
    @JsonProperty("account_id")
    private String accountId;

    public ReceiverBody() {
    }

    public ReceiverBody(String counterpartyId, String accountId) {
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
