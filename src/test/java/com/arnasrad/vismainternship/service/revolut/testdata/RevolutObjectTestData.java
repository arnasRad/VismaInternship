package com.arnasrad.vismainternship.service.revolut.testdata;

import com.arnasrad.vismainternship.mapping.JsonMapper;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDTO;
import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyDTO;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentDTO;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionDTO;

import java.util.List;

public class RevolutObjectTestData {

    private static final JsonMapper mapper = new JsonMapper();

    public static List<RevolutAccountDTO> getTestAccounts() {

        return mapper.getObjectListFromString(RevolutStringTestData.getAccountsString(), RevolutAccountDTO.class);
    }

    public static RevolutCounterpartyDTO getTestCounterparty() {

        return mapper.getObjectFromString(RevolutStringTestData.getCounterpartyString(),
                RevolutCounterpartyDTO.class);
    }

//    public static JSONObject getTestCounterpartyRequestBody() {
//
//        return mapper.getObjectFromString(RevolutStringTestData.getAddCounterpartyRequestBodyString(),
//                CounterpartyRequestBody.class);
//    }

    public static List<RevolutCounterpartyDTO> getTestCounterpartyList() {

        return mapper.getObjectListFromString(RevolutStringTestData.getCounterpartyListString(),
                RevolutCounterpartyDTO.class);
    }

    public static RevolutPaymentDTO getPayment() {

        return mapper.getObjectFromString(RevolutStringTestData.getPaymentString(), RevolutPaymentDTO.class);
    }

    public static List<RevolutTransactionDTO> getTransactionList() {

        return mapper.getObjectListFromString(RevolutStringTestData.getTransactionListString(),
                RevolutTransactionDTO.class);
    }

    public static RevolutTransactionDTO getTransaction() {

        return mapper.getObjectFromString(RevolutStringTestData.getTransactionString(), RevolutTransactionDTO.class);
    }
}
