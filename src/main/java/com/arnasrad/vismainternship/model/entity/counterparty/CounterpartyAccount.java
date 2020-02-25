package com.arnasrad.vismainternship.model.entity.counterparty;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CounterpartyAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String counterpartyAccountId;
    private String currency;
    private String type;
    private String accountNo;

    public CounterpartyAccount() {
    }

    public CounterpartyAccount(String counterpartyAccountId, String currency, String type, String accountNo) {
        this.counterpartyAccountId = counterpartyAccountId;
        this.currency = currency;
        this.type = type;
        this.accountNo = accountNo;
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
}
