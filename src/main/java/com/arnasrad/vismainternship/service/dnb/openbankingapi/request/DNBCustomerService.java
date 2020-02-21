package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.DNBCustomer;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.DNBCustomerInfo;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.builder.DnbRequestBuilderService;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.request.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    private final JsonMapperService jsonMapperService;

    @Autowired
    public DNBCustomerService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService,
                              JsonMapperService jsonMapperService) {

        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.jsonMapperService = jsonMapperService;
    }

    @Override
    public List<DNBCustomer> getCustomers()  {

        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getRequest();

        ResponseEntity<String> responseEntity = restTemplate.exchange(customersEndpoint, HttpMethod.GET,
                authorizedHttpEntity, String.class);

        String jsonResponse = responseEntity.getBody();

        return jsonMapperService.getObjectListFromString(jsonResponse, DNBCustomer.class);
    }

    @Override
    public DNBCustomerInfo getCurrentCustomerInfo()  {

        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<String> responseEntity = restTemplate.exchange(currentCustomerInfoEndpoint, HttpMethod.GET,
                authorizedHttpEntity, String.class);

        String jsonResponse = responseEntity.getBody();

        return jsonMapperService.getObjectFromString(jsonResponse, DNBCustomerInfo.class);
    }

    @Override
    public DNBCustomerInfo getCustomerInfo(String ssn)  {

        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<String> responseEntity = restTemplate.exchange(customerInfoEndpoint.concat(ssn), HttpMethod.GET,
                authorizedHttpEntity, String.class);

        String jsonResponse = responseEntity.getBody();

        return jsonMapperService.getObjectFromString(jsonResponse, DNBCustomerInfo.class);
    }

    public void setCustomersEndpoint(String customersEndpoint) {
        this.customersEndpoint = customersEndpoint;
    }

    public void setCurrentCustomerInfoEndpoint(String currentCustomerInfoEndpoint) {
        this.currentCustomerInfoEndpoint = currentCustomerInfoEndpoint;
    }

    public void setCustomerInfoEndpoint(String customerInfoEndpoint) {
        this.customerInfoEndpoint = customerInfoEndpoint;
    }

    @Override
    public String getBankId() {

        return BankId.DNB_ID.getBank();
    }
}
