package com.arnasrad.vismainternship.model.entity.revolut.counterparty;

import com.arnasrad.vismainternship.model.entity.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.entity.counterparty.CounterpartyAccount;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class RevolutCounterparty extends Counterparty {

    private String profileType;
    private String state;
    private Date createdAt;
    private Date updatedAt;

    public RevolutCounterparty() {
    }

    public RevolutCounterparty(String country, String id, String name, String phone,
                               List<? extends CounterpartyAccount> accounts,
                               String profileType, String state, Date createdAt, Date updatedAt) {

        super(country, id, name, phone, accounts);
        this.profileType = profileType;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<RevolutCounterpartyAccount> getRevolutAccounts() {

        List<CounterpartyAccount> counterpartyAccounts = super.getAccounts();
        List<RevolutCounterpartyAccount> revolutCounterpartyAccounts = new ArrayList<>();

        for (CounterpartyAccount counterpartyAccount : counterpartyAccounts) {
            revolutCounterpartyAccounts.add((RevolutCounterpartyAccount) counterpartyAccount);
        }

        return revolutCounterpartyAccounts;
    }
}
