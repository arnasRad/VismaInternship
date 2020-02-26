package com.arnasrad.vismainternship.model.entity.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LegsCounterparty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String legsCounterpartyId;
    private String accountId;
    private String type;

    public LegsCounterparty() {
    }

    public LegsCounterparty(String legsCounterpartyId, String accountId, String type) {
        this.legsCounterpartyId = legsCounterpartyId;
        this.accountId = accountId;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegsCounterpartyId() {
        return legsCounterpartyId;
    }

    public void setLegsCounterpartyId(String legsCounterpartyId) {
        this.legsCounterpartyId = legsCounterpartyId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
