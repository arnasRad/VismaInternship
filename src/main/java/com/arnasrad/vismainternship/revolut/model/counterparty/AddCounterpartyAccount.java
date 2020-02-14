package com.arnasrad.vismainternship.revolut.model.counterparty;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddCounterpartyAccount {

    private String id;
    private String currency;
    private String type;

    public AddCounterpartyAccount() {
    }

    public AddCounterpartyAccount(String id, String currency, String type) {
        this.id = id;
        this.currency = currency;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
