package com.arnasrad.vismainternship.service.integration;

import com.arnasrad.vismainternship.OpenBankingApp;
import com.arnasrad.vismainternship.model.account.Account;
import com.arnasrad.vismainternship.persistence.account.AccountRepository;
import com.arnasrad.vismainternship.service.testdata.ObjectTestData;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(OpenBankingApp.class);

    private final AccountRepository repository;

    @Autowired
    public AccountServiceTest(AccountRepository repository) {
        this.repository = repository;
    }

    @Test
    public void whenSaving5Accounts_then5AccountsAreInDB() {
        List<Account> expectedAccounts = ObjectTestData.getTestAccounts();

        for (Account account : expectedAccounts) {

            repository.save(account);
        }

        Iterable<Account> accountsIterable = repository.findAll();
        List<Account> actualAccounts = new ArrayList<>();
        accountsIterable.forEach(actualAccounts::add);

        assertEquals(expectedAccounts.size(), actualAccounts.size());
    }

    @Test
    public void whenSearchingForAnExistingAccountById_thenAccountIsFound() {
        repository.save(new Account("123", "Bauer", 10.01));
        repository.save(new Account("1234", "O'Brian", 10.02));
        repository.save(new Account("1235", "Bauer", 10.03));
        repository.save(new Account("1236", "Palmer", 10.04));
        repository.save(new Account("1237", "Dessler", 10.05));

        Optional<Account> account = repository.findById("123");
        assertDoesNotThrow(account::get);
    }

    @Test
    public void whenSearchingForAnExistingAccountByName_thenAccountIsFound() {
        repository.save(new Account("123", "Bauer", 10.01));
        repository.save(new Account("1234", "O'Brian", 10.02));
        repository.save(new Account("1235", "Bauer", 10.03));
        repository.save(new Account("1236", "Palmer", 10.04));
        repository.save(new Account("1237", "Dessler", 10.05));

        List<Account> accounts = repository.findByName("Bauer");
        assertNotEquals(0, accounts.size());

        Account account = accounts.get(0);
        assertEquals("Bauer", account.getName());
    }
}
