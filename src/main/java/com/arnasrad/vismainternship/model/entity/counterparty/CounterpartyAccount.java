package com.arnasrad.vismainternship.model.entity.counterparty;

import javax.persistence.*;

@Entity
public class CounterpartyAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String counterpartyAccountId;
    private String currency;
    private String type;
    private String accountNo;
    @ManyToOne
    private Counterparty counterparty;
    private String iban;
    private String sortCode;
    private String routingNumber;
    private String bic;
    private String recipientCharges;

    public CounterpartyAccount() {
    }

    public CounterpartyAccount(String counterpartyAccountId, String currency, String type, String accountNo, String iban, String sortCode, String routingNumber, String bic, String recipientCharges) {
        this.counterpartyAccountId = counterpartyAccountId;
        this.currency = currency;
        this.type = type;
        this.accountNo = accountNo;
        this.iban = iban;
        this.sortCode = sortCode;
        this.routingNumber = routingNumber;
        this.bic = bic;
        this.recipientCharges = recipientCharges;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCounterpartyAccountId() {
        return counterpartyAccountId;
    }

    public void setCounterpartyAccountId(String counterpartyAccountId) {
        this.counterpartyAccountId = counterpartyAccountId;
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

    public Counterparty getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getRecipientCharges() {
        return recipientCharges;
    }

    public void setRecipientCharges(String recipientCharges) {
        this.recipientCharges = recipientCharges;
    }
}
