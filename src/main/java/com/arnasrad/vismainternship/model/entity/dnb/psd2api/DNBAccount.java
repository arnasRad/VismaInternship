package com.arnasrad.vismainternship.model.entity.dnb.psd2api;

import com.arnasrad.vismainternship.model.entity.account.Account;

import javax.persistence.Entity;

@Entity
public class DNBAccount extends Account {

    public DNBAccount() {
    }

    public DNBAccount(String accountId, String name, Double balance) {
        super(accountId, name, balance);
    }
}
