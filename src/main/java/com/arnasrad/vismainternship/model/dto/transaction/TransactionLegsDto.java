package com.arnasrad.vismainternship.model.dto.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionLegsDto {

    @JsonProperty("leg_id")
    private String id;
    private Double amount;
    private String currency;
    @JsonProperty("account_id")
    private String accountId;
    private LegsCounterpartyDto counterparty;
    private String description;
    private Double balance;

    public TransactionLegsDto() {
    }

    public TransactionLegsDto(String id, Double amount, String currency, String accountId,
                              LegsCounterpartyDto counterparty, String description, Double balance) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.accountId = accountId;
        this.counterparty = counterparty;
        this.description = description;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LegsCounterpartyDto getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(LegsCounterpartyDto counterparty) {
        this.counterparty = counterparty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
