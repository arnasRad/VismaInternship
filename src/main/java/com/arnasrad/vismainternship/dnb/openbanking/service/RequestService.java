package com.arnasrad.vismainternship.dnb.openbanking.service;

import com.arnasrad.vismainternship.dnb.component.JsonResponseMapper;
import com.arnasrad.vismainternship.dnb.openbanking.model.card.Card;
import com.arnasrad.vismainternship.dnb.openbanking.model.customer.Customer;
import com.arnasrad.vismainternship.dnb.openbanking.model.customer.CustomerInfo;
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

@Service("dnb-request-service")
public class RequestService {

    @Value("${dnb.openbanking.endpoint.customers}")
    private String customersEndpoint;

    @Value("${dnb.openbanking.endpoint.current-customer-info}")
    private String currentCustomerInfoEndpoint;

    @Value("${dnb.openbanking.endpoint.customer-info}")
    private String customerInfoEndpoint;

    @Value("${dnb.openbanking.endpoint.cards}")
    private String cardsEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("dnb-openbanking-request-builder")
    private RequestBuilderService requestBuilderService;

    @Autowired
    @Qualifier("dnb-json-response-mapper")
    private JsonResponseMapper jsonResponseMapper;

    public List<Customer> getCustomers() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(customersEndpoint, HttpMethod.GET,
                requestBuilderService.getRequest(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad customers request"));

        return jsonResponseMapper.getCustomerListFromJsonString(jsonResponse);
    }

    public CustomerInfo getCurrentCustomerInfo() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(currentCustomerInfoEndpoint, HttpMethod.GET,
                requestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad customer-info request"));

        return jsonResponseMapper.getCustomerInfoFromJsonString(jsonResponse);
    }

    public CustomerInfo getCustomerInfo(String ssn) {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(customerInfoEndpoint + ssn, HttpMethod.GET,
                requestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad customer-info request"));

        return jsonResponseMapper.getCustomerInfoFromJsonString(jsonResponse);
    }

    public List<Card> getCards() {
        String jsonResponse = Optional.ofNullable(restTemplate.exchange(cardsEndpoint, HttpMethod.GET,
                requestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad cards request"));

        return jsonResponseMapper.getListFromJsonString(jsonResponse, Card.class);
    }
}
