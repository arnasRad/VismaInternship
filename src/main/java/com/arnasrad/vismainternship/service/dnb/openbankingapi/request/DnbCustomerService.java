package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DnbCustomerDto;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DnbCustomerInfoDto;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.builder.DnbRequestBuilderService;
import com.arnasrad.vismainternship.service.request.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DnbCustomerService implements CustomerService {

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    @Value("${dnb.openbanking.endpoint.customers}")
    private String customersEndpoint;
    @Value("${dnb.openbanking.endpoint.current-customer-info}")
    private String currentCustomerInfoEndpoint;
    @Value("${dnb.openbanking.endpoint.customer-info}")
    private String customerInfoEndpoint;

    public DnbCustomerService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService) {
        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
    }

    @Override
    public List<DnbCustomerDto> getCustomers() {
        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getRequest();

        ResponseEntity<List<DnbCustomerDto>> responseEntity = restTemplate.exchange(customersEndpoint, HttpMethod.GET,
                authorizedHttpEntity, new ParameterizedTypeReference<List<DnbCustomerDto>>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public DnbCustomerInfoDto getCurrentCustomerInfo() {
        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<DnbCustomerInfoDto> responseEntity = restTemplate.exchange(currentCustomerInfoEndpoint,
                HttpMethod.GET, authorizedHttpEntity, DnbCustomerInfoDto.class);

        return responseEntity.getBody();
    }

    @Override
    public DnbCustomerInfoDto getCustomerInfo(String ssn) {
        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<DnbCustomerInfoDto> responseEntity = restTemplate.exchange(customerInfoEndpoint.concat(ssn),
                HttpMethod.GET, authorizedHttpEntity, DnbCustomerInfoDto.class);

        return responseEntity.getBody();
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
