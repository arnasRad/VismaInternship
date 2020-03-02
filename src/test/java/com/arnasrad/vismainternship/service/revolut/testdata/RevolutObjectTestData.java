package com.arnasrad.vismainternship.service.revolut.testdata;

import com.arnasrad.vismainternship.mapping.JsonMapper;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDto;
import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentDto;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionDto;

import java.util.List;

public class RevolutObjectTestData {

    private static final JsonMapper mapper = new JsonMapper();

    public static List<RevolutAccountDto> getTestAccounts() {

        return mapper.getObjectListFromString(RevolutStringTestData.getAccountsString(), RevolutAccountDto.class);
    }

    public static RevolutCounterpartyDto getTestCounterparty() {

        return mapper.getObjectFromString(RevolutStringTestData.getCounterpartyString(),
                RevolutCounterpartyDto.class);
    }

//    public static JSONObject getTestCounterpartyRequestBody() {
//
//        return mapper.getObjectFromString(RevolutStringTestData.getAddCounterpartyRequestBodyString(),
//                CounterpartyRequestBody.class);
//    }

    public static List<RevolutCounterpartyDto> getTestCounterpartyList() {

        return mapper.getObjectListFromString(RevolutStringTestData.getCounterpartyListString(),
                RevolutCounterpartyDto.class);
    }

    public static RevolutPaymentDto getPayment() {

        return mapper.getObjectFromString(RevolutStringTestData.getPaymentString(), RevolutPaymentDto.class);
    }

    public static List<RevolutTransactionDto> getTransactionList() {

        return mapper.getObjectListFromString(RevolutStringTestData.getTransactionListString(),
                RevolutTransactionDto.class);
    }

    public static RevolutTransactionDto getTransaction() {

        return mapper.getObjectFromString(RevolutStringTestData.getTransactionString(), RevolutTransactionDto.class);
    }
}
