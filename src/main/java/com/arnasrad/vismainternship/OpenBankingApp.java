package com.arnasrad.vismainternship;

import com.arnasrad.vismainternship.model.account.Account;
import com.arnasrad.vismainternship.persistence.account.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class OpenBankingApp {

    private static final Logger logger = LoggerFactory.getLogger(OpenBankingApp.class);
    
    public static void main(String[] args) {
        SpringApplication.run(OpenBankingApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(AccountRepository repository) {
        return (args) -> {
            // TODO: move to integration test
            // save a few Accounts
            repository.save(new Account("123", "Bauer", 10.01));
            repository.save(new Account("1234", "O'Brian", 10.02));
            repository.save(new Account("1235", "Bauer", 10.03));
            repository.save(new Account("1236", "Palmer", 10.04));
            repository.save(new Account("1237", "Dessler", 10.05));

            // fetch all Accounts
            logger.info("Accounts found with findAll():");
            logger.info("-------------------------------");
            for (Account account : repository.findAll()) {
                logger.info(account.toString());
            }
            logger.info("");

            // fetch an individual Account by ID
            Optional<Account> account = repository.findById("123");
            logger.info("Account found with findById(123):");
            logger.info("--------------------------------");
            logger.info(account.orElseThrow(() -> new Exception()).toString());
            logger.info("");

            // fetch Accounts by last name
            logger.info("Account found with findByLastName('Bauer'):");
            logger.info("--------------------------------------------");
            repository.findByName("Bauer").forEach(bauer -> {
                logger.info(bauer.toString());
            });

            logger.info("");
        };
    }
}
