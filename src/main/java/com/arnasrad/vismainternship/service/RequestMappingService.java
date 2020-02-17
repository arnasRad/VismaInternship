package com.arnasrad.vismainternship.service;

import org.springframework.stereotype.Service;

@Service
public class RequestMappingService {
/*
    private static final String REVOLUT_ID = "revolut";
    private static final String DNB_ID = "dnb";

    @Value("${error.msg.no-functionality}")
    private String noFunctionalityMsg;

    @Value("${error.msg.wrong-bank}")
    private String wrongBankMsg;
    private final RevolutAccountService revolutAccountService;
    private final DNBAccountService dnbAccountService;
    private final RevolutCustomerService revolutCustomerService;
    private final DNBCustomerService dnbCustomerService;
    private final RevolutCardService revolutCardService;
    private final DNBCardService dnbCardService;
    private final RevolutPaymentService revolutPaymentService;
    private final DNBPaymentService dnbPaymentService;
    private final ModelConverterService modelConverterService;

    @Autowired
    public RequestMappingService(RevolutAccountService revolutAccountService, DNBAccountService dnbAccountService, RevolutCustomerService revolutCustomerService, DNBCustomerService dnbCustomerService, RevolutCardService revolutCardService, DNBCardService dnbCardService, RevolutPaymentService revolutPaymentService, DNBPaymentService dnbPaymentService, ModelConverterService modelConverterService) {
        this.revolutAccountService = revolutAccountService;
        this.dnbAccountService = dnbAccountService;
        this.revolutCustomerService = revolutCustomerService;
        this.dnbCustomerService = dnbCustomerService;
        this.revolutCardService = revolutCardService;
        this.dnbCardService = dnbCardService;
        this.revolutPaymentService = revolutPaymentService;
        this.dnbPaymentService = dnbPaymentService;
        this.modelConverterService = modelConverterService;
    }

    public Map<String, List<Account>> mapAccountsRequest(String bank) {

        Map<String, List<Account>> accounts = new HashMap<>();
        switch (bank) {
            case REVOLUT_ID:
                accounts.put(REVOLUT_ID,
                        modelConverterService.convertFromRevolutAccountList(revolutAccountService.getAccounts()));
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
                        modelConverterService.convertFromDnbCustomerList(dnbCustomerService.getCustomers()));
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
                        modelConverterService.convertFromDnbCardList(dnbCardService.getCards()));
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
                        modelConverterService.convertFromRevolutPayment(revolutPaymentService.createPayment(body)));
                return payments;
            case DNB_ID:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(noFunctionalityMsg, "DNB",
                        "Payments"));
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, wrongBankMsg);
        }
    }
*/
}
