package com.arnasrad.vismainternship;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class OpenBankingApp {
    
    public static void main(String[] args) {
        SpringApplication.run(OpenBankingApp.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {
        };
    }
}
