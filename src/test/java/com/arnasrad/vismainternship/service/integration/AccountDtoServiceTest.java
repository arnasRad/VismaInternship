package com.arnasrad.vismainternship.service.integration;

import com.arnasrad.vismainternship.OpenBankingApp;
import com.arnasrad.vismainternship.model.entity.account.Account;
import com.arnasrad.vismainternship.persistence.account.AccountRepository;
import com.arnasrad.vismainternship.service.testdata.ObjectTestData;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
public class AccountDtoServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(OpenBankingApp.class);

    private final AccountRepository repository;

    public AccountDtoServiceTest(AccountRepository repository) {
        this.repository = repository;
    }

    @Test
    public void whenSaving5Accounts_then5AccountsAreInDB() {
        List<Account> testAccounts = ObjectTestData.getTestAccounts();

        for (Account account : testAccounts) {
            repository.save(account);
        }

        Iterable<Account> accountsIterable = repository.findAll();
        List<Account> actualAccounts = new ArrayList<>();
        accountsIterable.forEach(actualAccounts::add);

        assertEquals(testAccounts.size(), actualAccounts.size());
    }

    @Test
    public void whenSearchingForASavedAccountByAccountId_thenAccountIsFound() {
        Account testAccount = new Account();
        testAccount.setAccountId("123");
        testAccount.setName("Bauer");
        testAccount.setBalance(10.01);
        repository.save(testAccount);

        List<Account> accounts = repository.findByAccountId("123");
        assertEquals(1, accounts.size());

        Account account = accounts.get(0);
        assertEquals("123", account.getName());
    }

    @Test
    public void whenSearchingForASavedAccountByWrongAccountId_thenNoAccountIsFound() {
        Account testAccount = new Account();
        testAccount.setAccountId("123");
        testAccount.setName("Bauer");
        testAccount.setBalance(10.01);
        repository.save(testAccount);

        List<Account> accounts = repository.findByAccountId("1234");
        assertEquals(0, accounts.size());
    }

    @Test
    public void whenSearchingForAnExistingAccountByName_thenAccountIsFound() {
        List<Account> testAccounts = ObjectTestData.getTestAccounts();

        for (Account account : testAccounts) {
            repository.save(account);
        }

        List<Account> accounts = repository.findByName("Bauer");
        assertNotEquals(0, accounts.size());

        Account account = accounts.get(0);
        assertEquals("Bauer", account.getName());
    }
}
