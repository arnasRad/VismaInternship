package com.arnasrad.vismainternship.interbankingapi.service;

import com.arnasrad.vismainternship.interbankingapi.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelConverterService {

    public List<Account> convertFromRevolutAccountList(List<com.arnasrad.vismainternship.revolut.model.Account> accounts) {

        List<Account> accountList = new ArrayList<>();

        accounts.forEach(account -> accountList.add(new Account(account.getId(), account.getName(), account.getBalance())));

        return accountList;
    }

    public List<Account> convertFromDnbAccountList(List<com.arnasrad.vismainternship.dnb.psd2.model.Account> accounts) {

        List<Account> accountList = new ArrayList<>();

        accounts.forEach(account -> accountList.add(new Account(account.getId(), account.getName(), account.getBalance())));

        return accountList;
    }
}
