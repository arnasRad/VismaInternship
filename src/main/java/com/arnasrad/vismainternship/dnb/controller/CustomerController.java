package com.arnasrad.vismainternship.dnb.controller;

import com.arnasrad.vismainternship.dnb.component.JsonResponseMapper;
import com.arnasrad.vismainternship.dnb.model.Customer;
import com.arnasrad.vismainternship.dnb.model.CustomerInfo;
import com.arnasrad.vismainternship.dnb.service.RequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CustomerController {

    @Value("${dnb.endpoint.customers}")
    private String customersEndpoint;

    @Value("${dnb.endpoint.customer-info}")
    private String customerInfoEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("dnb-request-builder")
    private RequestBuilderService requestBuilderService;

    @Autowired
    @Qualifier("dnb-json-response-mapper")
    private JsonResponseMapper jsonResponseMapper;

    @GetMapping("/dnb/test-customers")
    public List<Customer> getTestCustomers() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(customersEndpoint, HttpMethod.GET,
                requestBuilderService.getRequest(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad customers request"));

        return jsonResponseMapper.getCustomerListFromJsonString(jsonResponse);
    }

    @GetMapping("/dnb/customer-info")
    public CustomerInfo getCustomerInfo() {
        String jsonResponse = Optional.ofNullable(restTemplate.exchange(customerInfoEndpoint, HttpMethod.GET,
                requestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad customer-info request"));

        return jsonResponseMapper.getCustomerInfoFromJsonString(jsonResponse);
    }
}
