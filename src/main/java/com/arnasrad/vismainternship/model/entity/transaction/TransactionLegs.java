package com.arnasrad.vismainternship.model.entity.transaction;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class TransactionLegs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String transactionLegsId;
    private Double amount;
    private String currency;
    private String accountId;
    @ManyToOne(cascade = CascadeType.ALL)
    private LegsCounterparty counterparty;
    private String description;
    private Double balance;

    public TransactionLegs() {
    }

    public TransactionLegs(String transactionLegsId, Double amount, String currency, String accountId, LegsCounterparty counterparty, String description, Double balance) {
        this.transactionLegsId = transactionLegsId;
        this.amount = amount;
        this.currency = currency;
        this.accountId = accountId;
        this.counterparty = counterparty;
        this.description = description;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionLegsId() {
        return transactionLegsId;
    }

    public void setTransactionLegsId(String transactionLegsId) {
        this.transactionLegsId = transactionLegsId;
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
