package com.arnasrad.vismainternship.service;

import com.arnasrad.vismainternship.model.Account;
import com.arnasrad.vismainternship.model.Card;
import com.arnasrad.vismainternship.model.Customer;
import com.arnasrad.vismainternship.model.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelConverterService {

    public List<Account> convertFromRevolutAccountList(List<com.arnasrad.vismainternship.model.revolut.account.Account> accounts) {

        List<Account> accountList = new ArrayList<>();

        accounts.forEach(account -> accountList.add(new Account(account.getId(), account.getName(), account.getBalance())));

        return accountList;
    }

    public List<Account> convertFromDnbAccountList(List<com.arnasrad.vismainternship.model.dnb.psd2api.Account> accounts) {

        List<Account> accountList = new ArrayList<>();

        accounts.forEach(account -> accountList.add(new Account(account.getId(), account.getName(), account.getBalance())));

        return accountList;
    }

    public List<Customer> convertFromDnbCustomerList(List<com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.Customer> customers) {

        List<Customer> customerList = new ArrayList<>();

        customers.forEach(customer -> customerList.add(new Customer(customer.getCustomerName(), customer.getSsn())));

        return customerList;

    }

    public List<Card> convertFromDnbCardList(List<com.arnasrad.vismainternship.model.dnb.openbankingapi.card.Card> cards) {

        List<Card> cardList = new ArrayList<>();

        cards.forEach(card -> cardList.add(new Card(card.getCustomerId(), card.getCardId(), card.getAccountNumber(),
                card.getCreditBalance(), card.getDebitBalance(), card.getCardType(), card.getProductName())));

        return cardList;

    }

    public Payment convertFromRevolutPayment(com.arnasrad.vismainternship.model.revolut.payment.Payment payment) {

        return new Payment(payment.getId(), payment.getState(), payment.getCompletedAt());
    }
}
