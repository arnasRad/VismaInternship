package com.arnasrad.vismainternship.model.entity.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionLegs {

    @Id
    @JsonProperty("leg_id")
    private String id;
    private Double amount;
    private String currency;
    @JsonProperty("account_id")
    private String accountId;

    @ManyToOne(cascade = CascadeType.ALL)
    private LegsCounterparty counterparty;
    private String description;
    private Double balance;

    public TransactionLegs() {
    }

    public TransactionLegs(String id, Double amount, String currency, String accountId, LegsCounterparty counterparty, String description, Double balance) {
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

    public LegsCounterparty getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(LegsCounterparty counterparty) {
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
