package com.arnasrad.vismainternship.service;

import com.arnasrad.vismainternship.model.dnb.openbankingapi.card.Card;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.Customer;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.CustomerInfo;
import com.arnasrad.vismainternship.model.revolut.account.Account;
import com.arnasrad.vismainternship.model.revolut.account.AccountDetails;
import com.arnasrad.vismainternship.model.revolut.counterparty.AddCounterparty;
import com.arnasrad.vismainternship.model.revolut.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.revolut.payment.Payment;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.model.revolut.requestbody.TransferRequestBody;

import java.util.List;

public interface RequestService {

    List<Account> getAccounts();

    Account getAccount(String id);

    List<AccountDetails> getAccountDetails(String id);

    AddCounterparty addCounterparty(CounterpartyRequestBody body);

    List<Counterparty> getCounterparties();

    String createTransfer(TransferRequestBody body);

    Payment createPayment(CreatePaymentRequestBody body);

    List<Customer> getCustomers();

    CustomerInfo getCurrentCustomerInfo();

    CustomerInfo getCustomerInfo(String ssn);

    List<Card> getCards();
}
