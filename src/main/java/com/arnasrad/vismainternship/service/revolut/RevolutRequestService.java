package com.arnasrad.vismainternship.service.revolut;

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

@Service("revolut-request-service")
public class RevolutRequestService implements RequestService {

    @Value("${revolut.endpoint.accounts}")
    private String accountsEndpoint;

    @Value("${revolut.endpoint.counterparty}")
    private String counterpartyEndpoint;

    @Value("${revolut.endpoint.counterparties}")
    private String counterpartiesEndpoint;

    @Value("${revolut.endpoint.transfer}")
    private String transferEndpoint;

    @Value("${revolut.endpoint.payment}")
    private String paymentEndpoint;

    @Value("${constant.revolut-id-uppercase}")
    private String revolutId;

    private final RefreshTokenService refreshTokenService;
    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final JsonMapper jsonMapper;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public RevolutRequestService(RefreshTokenService refreshTokenService, RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService, JsonMapper jsonMapper, ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.refreshTokenService = refreshTokenService;
        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.jsonMapper = jsonMapper;
        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public List<Account> getAccounts() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-accounts"));

        return jsonMapper.getObjectListFromString(jsonResponse, Account.class);
    }

    @Override
    public Account getAccount(String id) {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(accountsEndpoint.concat("/").concat(id),
                HttpMethod.GET,
                revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-account"));

        return jsonMapper.getObjectFromString(jsonResponse, Account.class);
    }

    @Override
    public List<AccountDetails> getAccountDetails(String id) {

        String jsonResponse =
                Optional.ofNullable(restTemplate.exchange(accountsEndpoint.concat("/").concat(id).concat("/bank" +
                                "-details"),
                        HttpMethod.GET,
                        revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                        .orElseThrow(() -> exceptionBuilder.getException400("get-account-details"));

        return jsonMapper.getObjectListFromString(jsonResponse, AccountDetails.class);
    }

    @Override
    public AddCounterparty addCounterparty(CounterpartyRequestBody body) {

        String jsonResponse = Optional.ofNullable(restTemplate.postForEntity(counterpartyEndpoint,
                revolutRequestBuilderService.getCounterpartyRequest(body), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("add-counterparty"));

        return jsonMapper.getObjectFromString(jsonResponse, AddCounterparty.class);
    }

    @Override
    public List<Counterparty> getCounterparties() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(counterpartiesEndpoint, HttpMethod.GET,
                revolutRequestBuilderService.getCounterpartiesRequest(), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-counterparties"));

        return jsonMapper.getObjectListFromString(jsonResponse, Counterparty.class);
    }

    @Override
    public String createTransfer(TransferRequestBody body) {

        return Optional.ofNullable(restTemplate.postForEntity(transferEndpoint,
                revolutRequestBuilderService.getTransferRequest(body), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("create-transfer"));
    }

    @Override
    public Payment createPayment(CreatePaymentRequestBody body) {

        String jsonResponse = Optional.ofNullable(restTemplate.postForEntity(paymentEndpoint,
                revolutRequestBuilderService.getPaymentRequest(body), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("create-payment"));

        return jsonMapper.getObjectFromString(jsonResponse, Payment.class);
    }

    @Override
    public List<Customer> getCustomers() {

        throw exceptionBuilder.getNoFunctionalityException400(revolutId, "getCustomers");
    }

    @Override
    public CustomerInfo getCurrentCustomerInfo() {

        throw exceptionBuilder.getNoFunctionalityException400(revolutId, "getCurrentCustomerInfo");
    }

    @Override
    public CustomerInfo getCustomerInfo(String ssn) {

        throw exceptionBuilder.getNoFunctionalityException400(revolutId, "getCustomerInfo");
    }

    @Override
    public List<Card> getCards() {

        throw exceptionBuilder.getNoFunctionalityException400(revolutId, "getCards");
    }
}
