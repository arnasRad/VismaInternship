package com.arnasrad.vismainternship.service;

import com.arnasrad.vismainternship.model.Account;
import com.arnasrad.vismainternship.model.Card;
import com.arnasrad.vismainternship.model.Customer;
import com.arnasrad.vismainternship.model.Payment;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.card.DNBCard;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.DNBCustomer;
import com.arnasrad.vismainternship.model.revolut.account.RevolutAccount;
import com.arnasrad.vismainternship.model.revolut.payment.RevolutPayment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelConverterService {

    public List<Account> convertFromRevolutAccountList(List<RevolutAccount> revolutAccounts) {

        List<Account> accountList = new ArrayList<>();

        revolutAccounts.forEach(account -> accountList.add(new Account(account.getId(), account.getName(), account.getBalance())));

        return accountList;
    }

    public List<Account> convertFromDnbAccountList(List<com.arnasrad.vismainternship.model.dnb.psd2api.Account> accounts) {

        List<Account> accountList = new ArrayList<>();

        accounts.forEach(account -> accountList.add(new Account(account.getId(), account.getName(), account.getBalance())));

        return accountList;
    }

    public List<Customer> convertFromDnbCustomerList(List<DNBCustomer> DNBCustomers) {

        List<Customer> customerList = new ArrayList<>();

        DNBCustomers.forEach(DNBCustomer -> customerList.add(new Customer(DNBCustomer.getCustomerName(), DNBCustomer.getSsn())));

        return customerList;

    }

    public List<Card> convertFromDnbCardList(List<DNBCard> DNBCards) {

        List<Card> cardList = new ArrayList<>();

        DNBCards.forEach(DNBCard -> cardList.add(new Card(DNBCard.getCustomerId(), DNBCard.getCardId(), DNBCard.getAccountNumber(),
                DNBCard.getCreditBalance(), DNBCard.getDebitBalance(), DNBCard.getCardType(), DNBCard.getProductName())));

        return cardList;

    }

    public Payment convertFromRevolutPayment(RevolutPayment revolutPayment) {

        return new Payment(revolutPayment.getId(), revolutPayment.getState(), revolutPayment.getCompletedAt());
    }
}
