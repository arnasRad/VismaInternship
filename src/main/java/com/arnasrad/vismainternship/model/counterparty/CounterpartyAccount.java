package com.arnasrad.vismainternship.model.counterparty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CounterpartyAccount {

    private String id;
    private String currency;
    private String type;
    @JsonProperty("account_no")
    private String accountNo;

    public CounterpartyAccount() {
    }

    public CounterpartyAccount(String id, String currency, String type) {
        this.id = id;
        this.currency = currency;
        this.type = type;
    }

    public CounterpartyAccount(String id, String currency, String type, String accountNo) {
        this.id = id;
        this.currency = currency;
        this.type = type;
        this.accountNo = accountNo;
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

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}
