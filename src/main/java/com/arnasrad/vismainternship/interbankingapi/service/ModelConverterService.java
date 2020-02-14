package com.arnasrad.vismainternship.interbankingapi.service;

import com.arnasrad.vismainternship.interbankingapi.model.Account;
import com.arnasrad.vismainternship.interbankingapi.model.Card;
import com.arnasrad.vismainternship.interbankingapi.model.Customer;
import com.arnasrad.vismainternship.interbankingapi.model.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelConverterService {

    public List<Account> convertFromRevolutAccountList(List<com.arnasrad.vismainternship.revolut.model.account.Account> accounts) {

        List<Account> accountList = new ArrayList<>();

        accounts.forEach(account -> accountList.add(new Account(account.getId(), account.getName(), account.getBalance())));

        return accountList;
    }

    public List<Account> convertFromDnbAccountList(List<com.arnasrad.vismainternship.dnb.psd2.model.Account> accounts) {

        List<Account> accountList = new ArrayList<>();

        accounts.forEach(account -> accountList.add(new Account(account.getId(), account.getName(), account.getBalance())));

        return accountList;
    }

    public List<Customer> convertFromDnbCustomerList(List<com.arnasrad.vismainternship.dnb.openbanking.model.customer.Customer> customers) {

        List<Customer> customerList = new ArrayList<>();

        customers.forEach(customer -> customerList.add(new Customer(customer.getCustomerName(), customer.getSsn())));

        return customerList;

    }

    public List<Card> convertFromDnbCardList(List<com.arnasrad.vismainternship.dnb.openbanking.model.card.Card> cards) {

        List<Card> cardList = new ArrayList<>();

        cards.forEach(card -> cardList.add(new Card(card.getCustomerId(), card.getCardId(), card.getAccountNumber(),
                card.getCreditBalance(), card.getDebitBalance(), card.getCardType(), card.getProductName())));

        return cardList;

    }

    public Payment convertFromRevolutPayment(com.arnasrad.vismainternship.revolut.model.payment.Payment payment) {

        return new Payment(payment.getId(), payment.getState(), payment.getCompletedAt());
    }
}
