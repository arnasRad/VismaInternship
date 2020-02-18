package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.DNBCustomer;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.DNBCustomerInfo;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
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
    private final JsonMapperService jsonMapperService;

    @Autowired
    public DNBCustomerService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService,
                              JsonMapperService jsonMapperService) {

        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.jsonMapperService = jsonMapperService;
    }

    @Override
    public List<DNBCustomer> getCustomers()  throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(customersEndpoint, HttpMethod.GET,
                dnbRequestBuilderService.getRequest(), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST, "getCustomers")));

        return jsonMapperService.getObjectListFromString(jsonResponse, DNBCustomer.class);
    }

    @Override
    public DNBCustomerInfo getCurrentCustomerInfo()  throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(currentCustomerInfoEndpoint, HttpMethod.GET,
                dnbRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST,
                        "getCurrentCustomerInfo")));

        return jsonMapperService.getObjectFromString(jsonResponse, DNBCustomerInfo.class);
    }

    @Override
    public DNBCustomerInfo getCustomerInfo(String ssn)  throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(customerInfoEndpoint + ssn, HttpMethod.GET,
                dnbRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST,
                        "getCustomerInfo")));

        return jsonMapperService.getObjectFromString(jsonResponse, DNBCustomerInfo.class);
    }

    @Override
    public String getBankId() {

        return BankId.DNB_ID.getBank();
    }
}
