package com.arnasrad.vismainternship.revolut.service;

import com.arnasrad.vismainternship.revolut.component.JsonResponseMapper;
import com.arnasrad.vismainternship.revolut.model.account.Account;
import com.arnasrad.vismainternship.revolut.model.account.AccountDetails;
import com.arnasrad.vismainternship.revolut.model.counterparty.AddCounterparty;
import com.arnasrad.vismainternship.revolut.model.counterparty.Counterparty;
import com.arnasrad.vismainternship.revolut.model.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.revolut.model.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.revolut.model.requestbody.TransferRequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service("revolut-request-service")
public class RequestService {

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

    @Value("${error.msg.bad-request}")
    private String badRequestMsg;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("revolut-request-builder")
    private RequestBuilderService requestBuilderService;

    @Autowired
    @Qualifier("revolut-json-revolut-mapper")
    private JsonResponseMapper jsonResponseMapper;

    private final Logger logger = LoggerFactory.getLogger(RequestService.class);

    public List<Account> getAccounts() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                requestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(badRequestMsg,
                        "accounts")));

        return jsonResponseMapper.getObjectListFromString(jsonResponse, Account.class);
    }

    public Account getAccount(String id) {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(accountsEndpoint.concat("/").concat(id),
                HttpMethod.GET,
                requestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(badRequestMsg,
                        "account")));

        return jsonResponseMapper.getObjectFromString(jsonResponse, Account.class);
    }

    public List<AccountDetails> getAccountDetails(String id) {

        String jsonResponse =
                Optional.ofNullable(restTemplate.exchange(accountsEndpoint.concat("/").concat(id).concat("/bank" +
                                "-details"),
                        HttpMethod.GET,
                        requestBuilderService.getAuthorizedRequest(), String.class).getBody())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                String.format(badRequestMsg, "accountDetails")));

        return jsonResponseMapper.getObjectListFromString(jsonResponse, AccountDetails.class);
    }

    public AddCounterparty addCounterparty(CounterpartyRequestBody body) {

        String jsonResponse = Optional.ofNullable(restTemplate.postForEntity(counterpartyEndpoint,
                requestBuilderService.getCounterpartyRequest(body), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(badRequestMsg,
                        "counterparty")));

        return jsonResponseMapper.getObjectFromString(jsonResponse, AddCounterparty.class);
    }

    public List<Counterparty> getCounterparties() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(counterpartiesEndpoint, HttpMethod.GET,
                requestBuilderService.getCounterpartiesRequest(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(badRequestMsg,
                        "counterparties")));

        return jsonResponseMapper.getObjectListFromString(jsonResponse, Counterparty.class);
    }

    public String createTransfer(TransferRequestBody body) {

        return Optional.ofNullable(restTemplate.postForEntity(transferEndpoint,
                requestBuilderService.getTransferRequest(body), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(badRequestMsg,
                        "transfer")));
    }

    public String createPayment(CreatePaymentRequestBody body) {

        return Optional.ofNullable(restTemplate.postForEntity(paymentEndpoint,
                requestBuilderService.getPaymentRequest(body), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(badRequestMsg,
                        "payment")));
    }
}
