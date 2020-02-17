package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.Customer;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.CustomerInfo;
import com.arnasrad.vismainternship.service.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.builder.DnbRequestBuilderService;
import com.arnasrad.vismainternship.service.request.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class DNBCustomerService implements CustomerService {

    @Value("${dnb.openbanking.endpoint.customers}")
    private String customersEndpoint;

    @Value("${dnb.openbanking.endpoint.current-customer-info}")
    private String currentCustomerInfoEndpoint;

    @Value("${dnb.openbanking.endpoint.customer-info}")
    private String customerInfoEndpoint;

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    private final JsonMapper jsonMapper;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public DNBCustomerService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService, JsonMapper jsonMapper, ResponseStatusExceptionBuilderService exceptionBuilder) {

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
}
