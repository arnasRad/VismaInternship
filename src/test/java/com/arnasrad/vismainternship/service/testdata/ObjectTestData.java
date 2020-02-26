package com.arnasrad.vismainternship.service.testdata;

import com.arnasrad.vismainternship.model.entity.account.Account;

import java.util.ArrayList;
import java.util.List;

public class ObjectTestData {

    public static List<Account> getTestAccounts() {

        List<Account> expectedAccounts = new ArrayList<>();

        expectedAccounts.add(new Account("123", "Bauer", 10.01, null, null, null, null, null));
        expectedAccounts.add(new Account("1234", "O'Brian", 10.02, null, null, null, null, null));
        expectedAccounts.add(new Account("1235", "Bauer", 10.03, null, null, null, null, null));
        expectedAccounts.add(new Account("1236", "Palmer", 10.04, null, null, null, null, null));
        expectedAccounts.add(new Account("1237", "Dessler", 10.05, null, null, null, null, null));

        return expectedAccounts;
    }
}
