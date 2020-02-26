package com.arnasrad.vismainternship.model.entity.transaction;

import javax.persistence.*;

@Entity
public class TransactionLegs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionLegsId;
    private Double amount;
    private String currency;
    private String accountId;
    @ManyToOne(cascade = CascadeType.ALL)
    private LegsCounterparty counterparty;
    private String description;
    private Double balance;
    private Double billAmount;
    private String billCurrency;
    @ManyToOne
    private Transaction transaction;

    public TransactionLegs() {
    }

    public TransactionLegs(String transactionLegsId, Double amount, String currency, String accountId,
                           LegsCounterparty counterparty, String description, Double balance, Double billAmount,
                           String billCurrency) {
        this.transactionLegsId = transactionLegsId;
        this.amount = amount;
        this.currency = currency;
        this.accountId = accountId;
        this.counterparty = counterparty;
        this.description = description;
        this.balance = balance;
        this.billAmount = billAmount;
        this.billCurrency = billCurrency;
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

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillCurrency() {
        return billCurrency;
    }

    public void setBillCurrency(String billCurrency) {
        this.billCurrency = billCurrency;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
