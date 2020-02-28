package com.arnasrad.vismainternship.service.testdata;

import com.arnasrad.vismainternship.model.entity.account.Account;
import com.arnasrad.vismainternship.model.entity.account.AccountBuilder;

import java.util.ArrayList;
import java.util.List;

public class ObjectTestData {

    public static List<Account> getTestAccounts() {

        List<Account> expectedAccounts = new ArrayList<>();

        expectedAccounts.add(new AccountBuilder().setAccountId("123").setState("Bauer").setIsPublic(10.01).setAccountData(null).createAccount());
        expectedAccounts.add(new AccountBuilder().setAccountId("1234").setState("O'Brian").setIsPublic(10.02).setAccountData(null).createAccount());
        expectedAccounts.add(new AccountBuilder().setAccountId("1235").setState("Bauer").setIsPublic(10.03).setAccountData(null).createAccount());
        expectedAccounts.add(new AccountBuilder().setAccountId("1236").setState("Palmer").setIsPublic(10.04).setAccountData(null).createAccount());
        expectedAccounts.add(new AccountBuilder().setAccountId("1237").setState("Dessler").setIsPublic(10.05).setAccountData(null).createAccount());

        return expectedAccounts;
    }
}
