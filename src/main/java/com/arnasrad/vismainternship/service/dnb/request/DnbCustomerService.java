package com.arnasrad.vismainternship.service.dnb.request;

import com.arnasrad.vismainternship.mapper.dnb.DnbCustomerInfoMapper;
import com.arnasrad.vismainternship.mapper.dnb.DnbCustomerMapper;
import com.arnasrad.vismainternship.model.dto.CustomerDto;
import com.arnasrad.vismainternship.model.dto.CustomerInfoDto;
import com.arnasrad.vismainternship.model.dto.dnb.customer.DnbCustomerDto;
import com.arnasrad.vismainternship.model.dto.dnb.customer.DnbCustomerInfoDto;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.dnb.builder.DnbRequestBuilderService;
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
    private final DnbCustomerMapper dnbCustomerMapper;
    private final DnbCustomerInfoMapper dnbCustomerInfoMapper;
    @Value("${dnb.openbanking.endpoint.customers}")
    private String customersEndpoint;
    @Value("${dnb.openbanking.endpoint.current-customer-info}")
    private String currentCustomerInfoEndpoint;
    @Value("${dnb.openbanking.endpoint.customer-info}")
    private String customerInfoEndpoint;

    public DnbCustomerService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService,
                              DnbCustomerMapper dnbCustomerMapper, DnbCustomerInfoMapper dnbCustomerInfoMapper) {
        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.dnbCustomerMapper = dnbCustomerMapper;
        this.dnbCustomerInfoMapper = dnbCustomerInfoMapper;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getRequest();

        ResponseEntity<List<DnbCustomerDto>> responseEntity = restTemplate.exchange(customersEndpoint, HttpMethod.GET,
                authorizedHttpEntity, new ParameterizedTypeReference<List<DnbCustomerDto>>() {
                });

        List<DnbCustomerDto> dnbCustomerDtoList = responseEntity.getBody();
        return dnbCustomerMapper.mapToCustomerDtoList(dnbCustomerDtoList);
    }

    public CustomerInfoDto getCurrentCustomerDetails() {
        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<DnbCustomerInfoDto> responseEntity = restTemplate.exchange(currentCustomerInfoEndpoint,
                HttpMethod.GET, authorizedHttpEntity, DnbCustomerInfoDto.class);

        DnbCustomerInfoDto dnbCustomerInfoDto = responseEntity.getBody();
        return dnbCustomerInfoMapper.mapToCustomerInfoDto(dnbCustomerInfoDto);
    }

    public CustomerInfoDto getCustomerDetails(String ssn) {
        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<DnbCustomerInfoDto> responseEntity = restTemplate.exchange(customerInfoEndpoint.concat(ssn),
                HttpMethod.GET, authorizedHttpEntity, DnbCustomerInfoDto.class);

        DnbCustomerInfoDto dnbCustomerInfoDto = responseEntity.getBody();
        return dnbCustomerInfoMapper.mapToCustomerInfoDto(dnbCustomerInfoDto);
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
