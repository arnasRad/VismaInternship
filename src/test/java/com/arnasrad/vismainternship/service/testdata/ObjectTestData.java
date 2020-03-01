package com.arnasrad.vismainternship.service.testdata;

import com.arnasrad.vismainternship.model.entity.account.Account;

import java.util.ArrayList;
import java.util.List;

public class ObjectTestData {

    public static List<Account> getTestAccounts() {

        List<Account> accounts = new ArrayList<>();

        Account account = new Account();
        account.setAccountId("123");
        account.setName("Bauer");
        account.setBalance(10.01);
        accounts.add(account);

        account = new Account();
        account.setAccountId("1234");
        account.setName("O'Brian");
        account.setBalance(10.02);
        accounts.add(account);

        account = new Account();
        account.setAccountId("1235");
        account.setName("Bauer");
        account.setBalance(10.03);
        accounts.add(account);

        account = new Account();
        account.setAccountId("1236");
        account.setName("Palmer");
        account.setBalance(10.04);
        accounts.add(account);

        account = new Account();
        account.setAccountId("1237");
        account.setName("Dessler");
        account.setBalance(10.05);
        accounts.add(account);

        return accounts;
    }
}
