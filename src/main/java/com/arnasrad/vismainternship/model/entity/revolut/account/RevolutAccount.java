package com.arnasrad.vismainternship.model.entity.revolut.account;

import com.arnasrad.vismainternship.model.entity.account.Account;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class RevolutAccount extends Account {

    private String currency;
    private String state;
    private Boolean isPublic;
    private Date createdAt;
    private Date updatedAt;

    public RevolutAccount() {
    }

    public RevolutAccount(String id, String name, Double balance, String currency, String state, Boolean isPublic, Date createdAt, Date updatedAt) {
        super(id, name, balance);
        this.currency = currency;
        this.state = state;
        this.isPublic = isPublic;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
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
}
