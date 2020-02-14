package com.arnasrad.vismainternship.service;

import com.arnasrad.vismainternship.model.Account;
import com.arnasrad.vismainternship.model.Card;
import com.arnasrad.vismainternship.model.Customer;
import com.arnasrad.vismainternship.model.Payment;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.DNBRequestService;
import com.arnasrad.vismainternship.service.revolut.RevolutRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequestMappingService {

    private static final String REVOLUT_ID = "revolut";
    private static final String DNB_ID = "dnb";

    @Value("${error.msg.no-functionality}")
    private String noFunctionalityMsg;

    @Value("${error.msg.wrong-bank}")
    private String wrongBankMsg;

    @Autowired
    @Qualifier("revolut-request-service")
    private RevolutRequestService revolutRequestService;

    @Autowired
    @Qualifier("dnb-request-service")
    private DNBRequestService dnbRequestService;

    @Autowired
    private ModelConverterService modelConverterService;

    public Map<String, List<Account>> mapAccountsRequest(String bank) {

        Map<String, List<Account>> accounts = new HashMap<>();
        switch (bank) {
            case REVOLUT_ID:
                accounts.put(REVOLUT_ID,
                        modelConverterService.convertFromRevolutAccountList(revolutRequestService.getAccounts()));
                return accounts;
            case DNB_ID:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(noFunctionalityMsg, "DNB",
                        "Account"));
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, wrongBankMsg);
        }
    }

    public Map<String, List<Customer>> mapCustomersRequest(String bank) {

        Map<String, List<Customer>> customers = new HashMap<>();
        switch (bank) {
            case REVOLUT_ID:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(noFunctionalityMsg, "Revolut",
                        "Customer"));
            case DNB_ID:
                customers.put(DNB_ID,
                        modelConverterService.convertFromDnbCustomerList(dnbRequestService.getCustomers()));
                return customers;
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, wrongBankMsg);
        }
    }

    public Map<String, List<Card>> mapCardsRequest(String bank) {

        Map<String, List<Card>> cards = new HashMap<>();
        switch (bank) {
            case REVOLUT_ID:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(noFunctionalityMsg, "Revolut",
                        "Cards"));
            case DNB_ID:
                cards.put(DNB_ID,
                        modelConverterService.convertFromDnbCardList(dnbRequestService.getCards()));
                return cards;
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, wrongBankMsg);
        }
    }

    public Map<String, Payment> mapPaymentRequest(CreatePaymentRequestBody body, String bank) {

        Map<String, Payment> payments = new HashMap<>();

        switch (bank) {
            case REVOLUT_ID:
                payments.put(DNB_ID,
                        modelConverterService.convertFromRevolutPayment(revolutRequestService.createPayment(body)));
                return payments;
            case DNB_ID:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(noFunctionalityMsg, "DNB",
                        "Payments"));
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, wrongBankMsg);
        }
    }
}
