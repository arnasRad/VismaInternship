package com.arnasrad.vismainternship.service.revolut.testdata;

import com.arnasrad.vismainternship.mapping.JsonMapper;
import com.arnasrad.vismainternship.model.revolut.account.RevolutAccount;
import com.arnasrad.vismainternship.model.revolut.counterparty.RevolutCounterparty;
import com.arnasrad.vismainternship.model.revolut.payment.RevolutPayment;
import com.arnasrad.vismainternship.model.revolut.payment.RevolutTransaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.util.List;

public class RevolutObjectTestData {

    private static final JsonMapper mapper = new JsonMapper();

    public static List<RevolutAccount> getTestAccounts() {

        return mapper.getObjectListFromString(RevolutStringTestData.getAccountsString(), RevolutAccount.class);
    }

    public static RevolutCounterparty getTestCounterparty() {

        return mapper.getObjectFromString(RevolutStringTestData.getCounterpartyString(),
                RevolutCounterparty.class);
    }

    public static CounterpartyRequestBody getTestCounterpartyRequestBody() {

        return mapper.getObjectFromString(RevolutStringTestData.getAddCounterpartyRequestBodyString(),
                CounterpartyRequestBody.class);
    }

    public static List<RevolutCounterparty> getTestCounterpartyList() {

        return mapper.getObjectListFromString(RevolutStringTestData.getCounterpartyListString(),
                RevolutCounterparty.class);
    }

    public static RevolutPayment getPayment() {

        return mapper.getObjectFromString(RevolutStringTestData.getPaymentString(), RevolutPayment.class);
    }

    public static List<RevolutTransaction> getTransactionList() {

        return mapper.getObjectListFromString(RevolutStringTestData.getTransactionListString(),
                RevolutTransaction.class);
    }

    public static RevolutTransaction getTransaction() {

        return mapper.getObjectFromString(RevolutStringTestData.getTransactionString(), RevolutTransaction.class);
    }
}
