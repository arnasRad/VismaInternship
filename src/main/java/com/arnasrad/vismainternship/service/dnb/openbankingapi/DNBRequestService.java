package com.arnasrad.vismainternship.service.dnb.openbankingapi;

import com.arnasrad.vismainternship.component.JsonMapper;
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
import com.arnasrad.vismainternship.service.RequestService;
import com.arnasrad.vismainternship.service.ResponseStatusExceptionBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service("dnb-request-service")
public class DNBRequestService implements RequestService {

    @Value("${dnb.openbanking.endpoint.customers}")
    private String customersEndpoint;

    @Value("${dnb.openbanking.endpoint.current-customer-info}")
    private String currentCustomerInfoEndpoint;

    @Value("${dnb.openbanking.endpoint.customer-info}")
    private String customerInfoEndpoint;

    @Value("${dnb.openbanking.endpoint.cards}")
    private String cardsEndpoint;

    @Value("${constant.dnb-id-uppercase}")
    private String dnbId;

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    private final JsonMapper jsonMapper;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public DNBRequestService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService, JsonMapper jsonMapper, ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.jsonMapper = jsonMapper;
        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public List<Customer> getCustomers() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(customersEndpoint, HttpMethod.GET,
                dnbRequestBuilderService.getRequest(), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-customers"));

        return jsonMapper.getObjectListFromString(jsonResponse, Customer.class);
    }

    @Override
    public CustomerInfo getCurrentCustomerInfo() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(currentCustomerInfoEndpoint, HttpMethod.GET,
                dnbRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-current-customer-info"));

        return jsonMapper.getObjectFromString(jsonResponse, CustomerInfo.class);
    }

    @Override
    public CustomerInfo getCustomerInfo(String ssn) {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(customerInfoEndpoint + ssn, HttpMethod.GET,
                dnbRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-customer-info"));

        return jsonMapper.getObjectFromString(jsonResponse, CustomerInfo.class);
    }

    @Override
    public List<Card> getCards() {
        String jsonResponse = Optional.ofNullable(restTemplate.exchange(cardsEndpoint, HttpMethod.GET,
                dnbRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-cards"));

        return jsonMapper.getObjectListFromString(jsonResponse, Card.class);
    }

    @Override
    public List<Account> getAccounts() {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "getAccounts");
    }

    @Override
    public Account getAccount(String id) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "getAccount");
    }

    @Override
    public List<AccountDetails> getAccountDetails(String id) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "getAccountDetails");
    }

    @Override
    public AddCounterparty addCounterparty(CounterpartyRequestBody body) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "addCounterparty");
    }

    @Override
    public List<Counterparty> getCounterparties() {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "getCounterparties");
    }

    @Override
    public String createTransfer(TransferRequestBody body) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "createTransfer");
    }

    @Override
    public Payment createPayment(CreatePaymentRequestBody body) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "createPayment");
    }
}
